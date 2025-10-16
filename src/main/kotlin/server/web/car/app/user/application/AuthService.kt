package server.web.car.app.user.application

import org.springframework.context.annotation.Profile
import server.web.car.app.user.domain.model.User
import server.web.car.app.user.infrastructure.persistence.entity.RefreshToken
import server.web.car.app.user.infrastructure.persistence.repository.RefreshTokenRepository
import server.web.car.app.user.infrastructure.persistence.entity.UserEntity
import server.web.car.app.user.infrastructure.persistence.mapper.UserMapper
import server.web.car.app.user.infrastructure.persistence.repository.UserRepository
import server.web.car.security.HashEncoder
import server.web.car.security.JwtService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import org.springframework.transaction.annotation.Transactional
import server.web.car.app.address.infrastructure.persistence.mapper.CityMapper
import server.web.car.app.address.infrastructure.persistence.repository.CityRepository
import server.web.car.app.user.infrastructure.persistence.mapper.TypeAccountMapper
import server.web.car.utils.Mode
import java.security.MessageDigest
import java.time.Instant
import java.util.*
import kotlin.time.ExperimentalTime
//sudo docker run --name casa-db -e POSTGRES_PASSWORD=root -e POSTGRES_DB=testdb e- POSTGRES_USERNAME=postgres -p 5434:5432 -d postgres
//https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-22-04
@Service
@Profile(Mode.DEV)
class AuthService(
    private val jwtService: JwtService,
    private val userRepository: UserRepository,
    private val cityRepository: CityRepository,
    private val hashEncoder: HashEncoder,
    private val mapper: UserMapper,
    private val mapperAccount: TypeAccountMapper,
    private val mapperCity: CityMapper,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    data class TokenPair(
        val accessToken: String,
        val refreshToken: String
    )

    @OptIn(ExperimentalTime::class)
    fun register(user : User): Pair<User?, String> {
        val userEntity = userRepository.findByUsername(user.username.trim())
        if(userEntity != null) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "A user with that email already exists.")
        }
        val entity = UserEntity(
            userId = 0,
            username = user.username,
            password = hashEncoder.encode(user.password),
            typeAccount = mapperAccount.toEntity(user.typeAccount) ,
            email = user.email,
            phone = user.phone,
            city = mapperCity.toEntity(user.city)
        )
        val savedEntity = userRepository.save(entity)
        val newAccessToken = jwtService.generateAccessToken(savedEntity.userId.toHexString())
        val userData : User? = mapper.toDomain(savedEntity)
        val result = Pair<User?, String>(userData,newAccessToken)
        return result
    }

    fun login(username: String, password: String): Pair<TokenPair, User?> {
        val user = userRepository.findByUsername(username)
            ?: throw BadCredentialsException("Invalid credentials.")

        if(!hashEncoder.matches(password, user.password.toString())) {
            throw BadCredentialsException("Invalid credentials.")
        }

        val newAccessToken = jwtService.generateAccessToken(user.userId.toHexString())
        val newRefreshToken = jwtService.generateRefreshToken(user.userId.toHexString())

        storeRefreshToken(user.userId, newRefreshToken)
        val result = Pair<TokenPair, User?>(
            TokenPair(
                accessToken = newAccessToken,
                refreshToken = newRefreshToken
            )
            ,mapper.toDomain(user))
        return result
    }

    @Transactional
    fun refresh(refreshToken: String): TokenPair {
        if(!jwtService.validateRefreshToken(refreshToken)) {
            throw ResponseStatusException(HttpStatusCode.valueOf(401), "Invalid refresh token.")
        }

        val userId = jwtService.getUserIdFromToken(refreshToken)
        val user = userRepository.findById(userId.toLong()).orElseThrow {
            ResponseStatusException(HttpStatusCode.valueOf(401), "Invalid refresh token.")
        }

        val hashed = hashToken(refreshToken)
        refreshTokenRepository.findByUserIdAndHashedToken(user.userId, hashed)
            ?: throw ResponseStatusException(
                HttpStatusCode.valueOf(401),
                "Refresh token not recognized (maybe used or expired?)"
            )

        refreshTokenRepository.deleteByUserIdAndHashedToken(user.userId, hashed)

        val newAccessToken = jwtService.generateAccessToken(userId)
        val newRefreshToken = jwtService.generateRefreshToken(userId)

        storeRefreshToken(user.userId, newRefreshToken)

        return TokenPair(
            accessToken = newAccessToken,
            refreshToken = newRefreshToken
        )
    }

    @OptIn(ExperimentalTime::class)
    private fun storeRefreshToken(userId: Long, rawRefreshToken: String) {
        val hashed = hashToken(rawRefreshToken)
        val expiryMs = jwtService.refreshTokenValidityMs
        val expiresAt = Instant.now().plusMillis(expiryMs)

        refreshTokenRepository.save(
            RefreshToken(
                userId = userId,
                expiresAt = expiresAt,
                hashedToken = hashed
            )
        )
    }

    private fun hashToken(token: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(token.encodeToByteArray())
        return Base64.getEncoder().encodeToString(hashBytes)
    }
}