package server.web.casa.app.address.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "communes")
data class CommuneEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val communeId   : Int,
    @Column("name")
    val name        : String,
    @Column("districtId")
    val districtId  : Int
)
