package server.web.casa.app.property.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "PropertyFeatures")
data class PropertyFeatureEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val propertyFeatureId : Long,
    @ManyToMany(mappedBy = "features")
    val property : List<PropertyEntity>
)
