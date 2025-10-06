package server.web.casa.app.user.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import server.web.casa.app.user.infrastructure.persistence.RefreshToken

interface RefreshTokenRepository : JpaRepository<RefreshToken, Long> {
    fun findByUserIdAndHashedToken(userId: Long, hashedToken: String): RefreshToken?
    fun deleteByUserIdAndHashedToken(userId: Long, hashedToken: String)
}