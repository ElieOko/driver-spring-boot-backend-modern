package server.web.car.app.user.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "TypeAccounts")
data class TypeAccountEntity(
    @Id
    @Column("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val typeAccountId : Int = 0,
    @Column("name", unique = true)
    val name : String,
    @OneToOne(mappedBy = "typeAccount")
    val user: UserEntity? = null
)