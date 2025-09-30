package server.web.casa.app.address.infrastructure.persistence

import jakarta.persistence.*
import server.web.casa.app.user.infrastructure.persistence.UserEntity

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
    @OneToOne(mappedBy = "city")
    val user: UserEntity? = null,
    @OneToOne(mappedBy = "city")
    val district: DistrictEntity? = null
)
