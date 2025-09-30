package server.web.casa.app.property.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "PropertyTypes")
data class PropertyTypeEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val propertyTypeId : Int,
    @Column(name = "name")
    val name : String,
    @Column(name = "description")
    val description : String
)