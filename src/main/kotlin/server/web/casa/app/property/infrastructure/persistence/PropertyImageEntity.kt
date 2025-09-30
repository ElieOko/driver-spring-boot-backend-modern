package server.web.casa.app.property.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "PropertyImages")
data class PropertyImageEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val propertyImageId : Int,
    @Column(name = "propertyId")
    val propertyId : Int,
    @Column(name = "name")
    val name : String,
    @Column(name = "path_image")
    val path : String
)
