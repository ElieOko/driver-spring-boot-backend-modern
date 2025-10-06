package server.web.casa.app.property.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "PropertyFavorites")
data class PropertyFavoriteEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val propertyFavoriteId : Int,
//    @Column(name = "userId")
//    val userId : Int,
//    @Column(name = "propertyId")
//    val propertyId : Int,
    @ManyToMany(mappedBy = "favorites")
    val property : List<PropertyEntity>
)
