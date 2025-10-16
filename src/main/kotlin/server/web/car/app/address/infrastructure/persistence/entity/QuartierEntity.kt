package server.web.car.app.address.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "quartiers")
data class QuartierEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val quartierId  : Long,
    @OneToOne
    @JoinColumn("commune_id")
    val commune   : CommuneEntity,
    @Column("name")
    val name        : String,
)
