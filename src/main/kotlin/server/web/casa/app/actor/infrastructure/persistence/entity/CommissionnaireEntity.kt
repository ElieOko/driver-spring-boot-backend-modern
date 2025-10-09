package server.web.casa.app.actor.infrastructure.persistence.entity

import jakarta.persistence.*
import server.web.casa.app.user.infrastructure.persistence.entity.UserEntity

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
    @OneToOne
    @JoinColumn(name = "userId")
    val user : UserEntity?,
    @OneToOne
    @JoinColumn(name = "typeCardId")
    val typeCard : TypeCardEntity,
    @Column("numberCard")
    val numberCard  : String? = null
)
