package server.web.casa.app.actor.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "commissionnaires")
data class CommissionnaireEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val commissionnaireId : Int,
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
    @Column("userId")
    val userId      : Int,
    @Column("typeCardId")
    val typeCardId  : Int,
    @Column("numberCard")
    val numberCard  : String? = null
)
