package server.web.casa.app.user.infrastructure.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import server.web.casa.app.address.infrastructure.persistence.CityEntity
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Table(name = "users")
@Entity
data class UserEntity @OptIn(ExperimentalTime::class) constructor(
    @Id
    @Column("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long,
    @OneToOne
    @JoinColumn("typeAccountId")
    val typeAccount: TypeAccountEntity,
    @OneToOne
    @JoinColumn(name = "city_id")
    val city: CityEntity,
    @Column("username", unique = true)
    val username: String,
    @Column("password", nullable = false)
    val password: String?,
    @Column("email", nullable = true)
    val email: String? = null,
    @Column("phone", nullable = true)
    val phone: String,
    @Column("createdAt")
    val createdAt: Instant = Clock.System.now(),
)
