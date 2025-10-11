package server.web.casa.app.property.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "PropertyFeatures")
data class PropertyFeatureEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val propertyPropertyFeature : Long,
    @ManyToMany(mappedBy = "features")
    val property : List<PropertyEntity>
)
