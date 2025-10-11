package server.web.casa.app.property.infrastructure.persistence.entity

import jakarta.persistence.*
import server.web.casa.app.address.infrastructure.persistence.entity.CityEntity
import server.web.casa.app.address.infrastructure.persistence.entity.CommuneEntity
import server.web.casa.app.user.infrastructure.persistence.entity.UserEntity
import java.time.LocalDate

@Entity
@Table(name = "properties")
data class PropertyEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val propertyId : Long,
    @Column(name = "title")
    val title : String,
    @Column(name = "description", nullable = true)
    val description : String? = "",
    @Column(name = "price")
    val price : Double,
    @Column(name = "surface", nullable = true)
    val surface :Double? = null,
    @Column(name = "rooms", nullable = true)
    val rooms :Int? = 0,
    @Column(name = "bedrooms", nullable = true)
    val bedrooms : Int? = 0,
    @Column(name = "kitchen", nullable = true)
    val kitchen : Int? = 0,
    @Column(name = "livingRoom", nullable = true)
    val livingRoom : Int? = 0,
    @Column(name = "bathroom", nullable = true)
    val bathroom : Int? = 0,
    @Column(name = "floor", nullable = true)
    val floor : Int? = 0,
    @Column(name = "address")
    val address : String,
    @ManyToOne
    @JoinColumn("city_id")
    val city : CityEntity,
    @Column(name = "postalCode", nullable = true)
    val postalCode : String? = "",
    @ManyToOne
    @JoinColumn("commune_id")
    val commune : CommuneEntity,
    @Column(name = "quartier")
    val quartier  : String,
    @Column(name = "sold")
    val sold : Boolean,
    @Column(name = "transactionType")
    val transactionType : String,
    @ManyToOne
    @JoinColumn("property_type_id")
    val propertyType : PropertyTypeEntity,
    @ManyToOne
    @JoinColumn("user_id")
    val user : UserEntity,
    @Column(name = "latitude", nullable = true)
    val latitude : Double? = null,
    @Column(name = "longitude", nullable = true)
    val longitude : Double? = null,
    @Column(name = "isAvailable")
    val isAvailable : Boolean = true,
    @Column("createdAt")
    val createdAt: LocalDate = LocalDate.now(),
    @Column("updatedAt")
    val updatedAt: LocalDate = LocalDate.now(),
    @OneToMany(mappedBy = "property")
    val propertyImage : List<PropertyImageEntity?> = emptyList(),
    @OneToMany(mappedBy = "property")
    val propertyImageRoom : List<PropertyImageRoomEntity?> = emptyList(),
    @OneToMany(mappedBy = "property")
    val propertyImageLivingRoom : List<PropertyImageLivingRoomEntity?> = emptyList(),
    @OneToMany(mappedBy = "property")
    val propertyImageKitchen : List<PropertyImageKitchenEntity?> = emptyList(),

    @ManyToMany
    @JoinTable(
        "PropertyFeatures",
        joinColumns = [JoinColumn("property_id")],
        inverseJoinColumns = [JoinColumn("user_id")]
    )
    val features : List<PropertyFeatureEntity> = emptyList(),

    @ManyToMany
    @JoinTable(
        "PropertyFavorites",
        joinColumns = [JoinColumn("property_id")],
        inverseJoinColumns = [JoinColumn("user_id")]
    )
    val favorites : List<PropertyFavoriteEntity> = emptyList()
)
