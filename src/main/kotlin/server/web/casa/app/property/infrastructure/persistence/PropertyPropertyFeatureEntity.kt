package server.web.casa.app.property.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "PropertyPropertyFeatures")
data class PropertyPropertyFeatureEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val propertyPropertyFeature : Int,
    @Column(name = "propertyId")
    val propertyId : Int,
    @Column(name = "propertyFeatureId")
    val propertyFeatureId : Int
)
