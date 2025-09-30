package server.web.casa.app.address.infrastructure.persistence

import jakarta.persistence.*
import server.web.casa.app.user.infrastructure.persistence.UserEntity

@Entity
@Table(name = "countries")
data class CountryEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val countryId : Long,
    @Column("name")
    val name : String,
    @OneToOne(mappedBy = "country")
    val city : CityEntity? = null,

)
