package server.web.car.app.actor.infrastructure.persistence.entity

import jakarta.persistence.*
import server.web.car.app.user.infrastructure.persistence.entity.UserEntity

@Entity
@Table(name = "acheteurs")
data class AcheteurEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val acheteurId : Long,
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
    val numberCard  : String? = null,
)
