package server.web.casa.app.actor.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "bailleurs")
data class BailleurEntity(
    @Id
    @Column("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bailleurId  : Int,
    @Column("firstName")
    val firstName   : String,
    @Column("lastName")
    val lastName    : String,
    @Column("fullName")
    val fullName    : String,
    @Column("address")
    val address     : String,
    @Column("images")
    val images      : String,
    @Column("cardFront")
    val cardFront   : String,
    @Column("cardBack")
    val cardBack    : String,
    @Column("parrainId")
    val parrainId   : Int? = null,
    @Column("userId")
    val userId      : Int,
    @Column("typeCardId")
    val typeCardId  : Int,
    @Column("numberCard")
    val numberCard  : String? = null,
    @Column("note")
    val note        : String? = null
)
