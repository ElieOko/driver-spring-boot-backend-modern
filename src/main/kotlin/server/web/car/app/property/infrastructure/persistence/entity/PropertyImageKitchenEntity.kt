package server.web.car.app.property.infrastructure.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Table(name = "property_image_kitchens")
@Entity
data class PropertyImageKitchenEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val propertyImageKitchenId : Long,
    @ManyToOne
    @JoinColumn("property_id")
    val property : PropertyEntity? = null,
    @Column(name = "name")
    val name : String,
    @Column(name = "path_image")
    val path : String
)
