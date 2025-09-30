package server.web.casa.app.address.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "quartiers")
data class QuartierEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val quartierId  : Int,
    @Column("name")
    val name        : String,
    @Column("communeId")
    val communeId   : Int
)
