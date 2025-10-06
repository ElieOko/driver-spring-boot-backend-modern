package server.web.casa.app.actor.infrastructure.persistence.entity

import jakarta.persistence.*
import server.web.casa.app.user.infrastructure.persistence.entity.UserEntity

@Entity
@Table(name = "bailleurs")
data class BailleurEntity(
    @Id
    @Column("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bailleurId : Long,
    @Column("firstName")
    val firstName : String,
    @Column("lastName")
    val lastName : String,
    @Column("fullName")
    val fullName : String,
    @Column("address")
    val address : String,
    @Column("images")
    val images : String,
    @Column("cardFront")
    val cardFront : String,
    @Column("cardBack")
    val cardBack : String,
    @OneToOne
    @JoinColumn(name = "parrainId")
    val parrain : UserEntity? = null,
    @OneToOne
    @JoinColumn(name = "userId")
    val user : UserEntity?,
    @OneToOne
    @JoinColumn(name = "typeCardId")
    val typeCard : TypeCardEntity,
    @Column("numberCard")
    val numberCard : String? = null,
    @Column("note")
    val note : String? = null
)
