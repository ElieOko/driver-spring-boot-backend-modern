package server.web.car.app.address.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "districts")
data class DistrictEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val districtId  : Long = 0,
    @ManyToOne
    @JoinColumn("city_id")
    val city      : CityEntity,
    @Column("name")
    val name        : String,
    @OneToMany(mappedBy = "district", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val commune: List<CommuneEntity> = emptyList()
)
