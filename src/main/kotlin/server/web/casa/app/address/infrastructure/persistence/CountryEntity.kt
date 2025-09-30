package server.web.casa.app.address.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "countries")
data class CountryEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val cityId : Int,
    @Column("name")
    val name : String
)
