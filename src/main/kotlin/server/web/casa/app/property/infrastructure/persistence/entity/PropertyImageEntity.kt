package server.web.casa.app.property.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "PropertyImages")
data class PropertyImageEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val propertyImageId : Long,
    @ManyToOne
    @JoinColumn("property_id", nullable = true)
    val property : PropertyEntity,
    @Column(name = "name")
    val name : String,
    @Column(name = "path_image")
    val path : String
)
