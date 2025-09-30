package server.web.casa.app.address.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "districts")
data class DistrictEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val districtId  : Int,
    @OneToOne
    @JoinColumn("city_id")
    val city      : CityEntity,
    @Column("name")
    val name        : String,
    @OneToOne(mappedBy = "district")
    val commune: CommuneEntity? = null,

)
