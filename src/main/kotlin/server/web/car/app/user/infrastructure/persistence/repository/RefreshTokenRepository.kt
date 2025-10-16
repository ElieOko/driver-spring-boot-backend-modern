package server.web.car.app.user.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import server.web.car.app.user.infrastructure.persistence.entity.RefreshToken

interface RefreshTokenRepository : JpaRepository<RefreshToken, Long> {
    fun findByUserIdAndHashedToken(userId: Long, hashedToken: String): RefreshToken?
    fun deleteByUserIdAndHashedToken(userId: Long, hashedToken: String)
}