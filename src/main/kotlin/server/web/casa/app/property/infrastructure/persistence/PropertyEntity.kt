package server.web.casa.app.property.infrastructure.persistence

import jakarta.persistence.*
import server.web.casa.app.address.infrastructure.persistence.CityEntity
import server.web.casa.app.address.infrastructure.persistence.CommuneEntity
import server.web.casa.app.user.infrastructure.persistence.UserEntity
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Entity
@Table(name = "properties")
data class PropertyEntity @OptIn(ExperimentalTime::class) constructor(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val propertyId : Int,
    @Column(name = "title")
    val title : String,
    @Column(name = "description")
    val description : String,
    @Column(name = "price")
    val price : Double,
    @Column(name = "surface")
    val surface :Double,
    @Column(name = "rooms")
    val rooms :Int,
    @Column(name = "bedrooms")
    val bedrooms : Int,
    @Column(name = "kitchen")
    val kitchen : Int,
    @Column(name = "livingRoom")
    val livingRoom : Int,
    @Column(name = "bathroom")
    val bathroom : Int,
    @Column(name = "floor")
    val floor : Int,
    @Column(name = "address")
    val address : String,
    @ManyToOne
    @JoinColumn("city_id")
    val city : CityEntity,
    @Column(name = "postalCode")
    val postalCode : String,
    @ManyToOne
    @JoinColumn("commune_id")
    val commune : CommuneEntity,
    @Column(name = "quartier")
    val quartier  : String,
    @Column(name = "sold")
    val sold : Boolean,
    @Column(name = "transactionType")
    val transactionType : String,
    @OneToOne
    @JoinColumn("property_type_id")
    val propertyType : PropertyEntity? = null,
    @ManyToOne
    @JoinColumn("user_id")
    val user : UserEntity,
    @Column(name = "latitude")
    val latitude : Double,
    @Column(name = "longitude")
    val longitude : Double,
    @Column(name = "isAvailable")
    val isAvailable : Boolean,
    @Column("createdAt")
    val createdAt: Instant = Clock.System.now(),
    @Column("updatedAt")
    val updatedAt: Instant = Clock.System.now(),

    @ManyToMany
    @JoinTable(
        "PropertyFavorites",
        joinColumns = [JoinColumn("property_id")],
        inverseJoinColumns = [JoinColumn("user_id")]
    )
    val favorites : List<PropertyFavoriteEntity> = emptyList()


)
