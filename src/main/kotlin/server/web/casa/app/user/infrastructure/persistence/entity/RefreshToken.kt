package server.web.casa.app.user.infrastructure.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Entity
@Table(name = "refresh_tokens")
data class RefreshToken @OptIn(ExperimentalTime::class) constructor(
    @Id
    @Column("userId")
    val userId: Long,
    @Column(name = "expires_at")
    val expiresAt: java.time.Instant?,
    @Column("hashedToken")
    val hashedToken: String,
    @Column("createdAt")
    val createdAt: Instant = Clock.System.now()
)