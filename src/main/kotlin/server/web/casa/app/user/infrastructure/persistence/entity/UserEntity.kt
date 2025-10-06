package server.web.casa.app.user.infrastructure.persistence.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import server.web.casa.app.actor.infrastructure.persistence.entity.BailleurEntity
import server.web.casa.app.address.infrastructure.persistence.entity.CityEntity
import server.web.casa.app.address.infrastructure.persistence.entity.DistrictEntity
import server.web.casa.app.property.infrastructure.persistence.PropertyEntity
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityId")
    val city: CityEntity,
    @Column("username", unique = true)
    val username: String,
    @Column("password", nullable = false)
    @JsonIgnore
    val password: String?,
    @Column("email", nullable = true)
    val email: String? = null,
    @Column("phone", nullable = true)
    val phone: String,
    @Column("createdAt")
    val createdAt: Instant = Clock.System.now(),
    @OneToMany(mappedBy = "user")
    val properties : List<PropertyEntity> = emptyList(),
    @OneToOne(mappedBy = "user")
    val bailleur: BailleurEntity? = null,
    @OneToOne(mappedBy = "parrain")
    val parrainBailleur: BailleurEntity? = null,

)
