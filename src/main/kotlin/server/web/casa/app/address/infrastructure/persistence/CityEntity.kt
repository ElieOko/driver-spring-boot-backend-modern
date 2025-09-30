package server.web.casa.app.address.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "cities")
data class CityEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val cityId : Int,
    @Column("name")
    val name : String,
    @Column("countryId")
    val countryId : Int
)
