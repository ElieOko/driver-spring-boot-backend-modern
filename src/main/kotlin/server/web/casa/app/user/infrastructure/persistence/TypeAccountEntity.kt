package server.web.casa.app.user.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "TypeAccounts")
data class TypeAccountEntity(
    @Id
    @Column("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val typeAccountId : Int,
    @Column("name")
    val name : String
)