package server.web.casa.app.address.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "districts")
data class DistrictEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val districtId  : Int,
    @Column("name")
    val name        : String,
    @Column("cityId")
    val cityId      : Int
)
