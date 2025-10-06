package server.web.casa.app.actor.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "typecards")
data class TypeCardEntity(
    @Id
    @Column("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val typeCardId : Long,
    @Column("name")
    val name : String,
    @OneToOne(mappedBy = "typeCard")
    val bailleur: BailleurEntity? = null,
)
