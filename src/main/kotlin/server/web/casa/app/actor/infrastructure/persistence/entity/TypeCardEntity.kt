package server.web.casa.app.actor.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "commissionnaires")
data class TypeCardEntity(
    @Id
    @Column("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val typeCardId : Int,
    @Column("name")
    val name : String
)
