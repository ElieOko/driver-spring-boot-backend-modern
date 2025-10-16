package server.web.car.app.property.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "PropertyFavorites")
data class PropertyFavoriteEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val propertyFavoriteId : Long,
    @ManyToMany(mappedBy = "favorites")
    val property : List<PropertyEntity?> = emptyList()
)
