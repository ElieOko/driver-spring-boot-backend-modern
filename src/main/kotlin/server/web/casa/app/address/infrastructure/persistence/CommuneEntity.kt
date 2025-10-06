package server.web.casa.app.address.infrastructure.persistence

import jakarta.persistence.*
import server.web.casa.app.property.infrastructure.persistence.PropertyEntity

@Entity
@Table(name = "communes")
data class CommuneEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val communeId   : Int,
    @OneToOne
    @JoinColumn("district_id")
    val district  : DistrictEntity,
    @Column("name")
    val name        : String,
    @OneToOne(mappedBy = "commune")
    val quartier : QuartierEntity? = null,
    @OneToMany(mappedBy = "commune")
    val properties : List<PropertyEntity> = emptyList()

)
