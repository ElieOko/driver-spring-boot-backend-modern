package server.web.casa.app.address.infrastructure.persistence.entity

import jakarta.persistence.*
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyEntity
import server.web.casa.app.user.infrastructure.persistence.entity.UserEntity

@Entity
@Table(name = "cities")
data class CityEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val cityId : Int,
    @OneToOne
    @JoinColumn("country_id")
    val country : CountryEntity,
    @Column("name")
    val name : String,
    @OneToMany(mappedBy = "city", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val user: List<UserEntity> = emptyList(),
    @OneToOne(mappedBy = "city")
    val district: DistrictEntity? = null,
    @OneToMany(mappedBy = "city")
    val properties : List<PropertyEntity> = emptyList()
)
