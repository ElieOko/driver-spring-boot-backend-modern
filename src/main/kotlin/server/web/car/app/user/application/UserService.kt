package server.web.car.app.user.application

import server.web.car.app.user.domain.model.UserAuth
import server.web.car.app.user.domain.model.User
import server.web.car.app.user.infrastructure.persistence.entity.UserEntity
import server.web.car.app.user.infrastructure.persistence.mapper.UserMapper
import server.web.car.app.user.infrastructure.persistence.repository.UserRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import server.web.car.app.address.infrastructure.persistence.mapper.CityMapper
import server.web.car.app.user.infrastructure.persistence.mapper.TypeAccountMapper
import server.web.car.utils.Mode
import kotlin.time.ExperimentalTime

@Service
@Profile(Mode.DEV)
class UserService(
    private val repository: UserRepository,
    private val mapper: UserMapper,
    private val mapperAccount: TypeAccountMapper,
    private val mapperCity: CityMapper,
) {
    val name = "utilisateur"
    @OptIn(ExperimentalTime::class)
    fun createUser(user: User) : User? {

        val entityToSave = UserEntity(
            userId = 0,
            username = user.username,
            password = user.password,
            typeAccount = mapperAccount.toEntity(user.typeAccount) ,
            email = user.email,
            phone = user.phone,
            city = mapperCity.toEntity(user.city)
        )
        val savedEntity = repository.save(entityToSave)
        return mapper.toDomain(savedEntity)
    }

    fun findAllUser() : List<User?> {
        val allEntityUser = repository.findAll()
        return allEntityUser.stream().map {
            mapper.toDomain(it)
        }.toList()
    }

    fun findIdUser(id : Long) : User?{
        val userEntity = repository.findById(id).orElseThrow{->
            EntityNotFoundException("Aucun $name avec cet identifiant $id")
        }
        return mapper.toDomain(userEntity)
    }

    @OptIn(ExperimentalTime::class)
    fun updateUser(
        id : Long,
        user : User
    ): User ?{
        val userEntity = repository.findById(id).orElseThrow{->
            EntityNotFoundException("Aucun $name avec cet identifiant $id")
        }
        val entityToUpdate = UserEntity(
            userId = user.userId,
            username = user.username,
            password = user.password,
            typeAccount = mapperAccount.toEntity(user.typeAccount),
            email = user.email,
            phone = user.phone,
            city = mapperCity.toEntity(user.city)
        )
        val updatedUser = repository.save(entityToUpdate)

        return mapper.toDomain(updatedUser)
    }

    fun deleteUser(id : Long){
        if (!repository.existsById(id)){
            EntityNotFoundException("Aucun $name avec cet identifiant $id")
        }
        repository.deleteById(id)
    }

    fun login(userAuth : UserAuth) : User? {
        return null
    }

}