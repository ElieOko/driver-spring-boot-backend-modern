package server.web.casa.app.property.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "PropertyFeatures")
data class PropertyFeatureEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val propertyFeatureId : Int,
    @Column(name = "name")
    val name : String,
    @Column(name = "description")
    val description : String
)
