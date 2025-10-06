package server.web.casa.app.actor.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "locataires")
data class LocataireEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    val locataireId : Long,
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
    val userId      : Long,
    @Column("typeCardId")
    val typeCardId  : Long,
    @Column("numberCard")
    val numberCard  : String? = null,
)
