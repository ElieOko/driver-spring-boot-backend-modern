package server.web.car.app.actor.infrastructure.persistence.entity

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
    val bailleur: VendeurEntity? = null,
    @OneToOne(mappedBy = "typeCard")
    val locataire: AcheteurEntity? = null,
    @OneToOne(mappedBy = "typeCard")
    val commissionnaire: CommissionnaireEntity? = null,
)
