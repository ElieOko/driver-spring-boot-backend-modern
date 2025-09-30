package server.web.casa.app.property.infrastructure.persistence

import jakarta.persistence.*
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
    @Column(name = "cityId")
    val cityId : Int,
    @Column(name = "postalCode")
    val postalCode : String,
    @Column(name = "communeId")
    val communeId : Int,
    @Column(name = "quartier")
    val quartier  : String,
    @Column(name = "sold")
    val sold : Boolean,
    @Column(name = "transactionType")
    val transactionType : String,
    @Column(name = "propertyTypeId")
    val propertyTypeId : Int,
    @Column(name = "userId")
    val userId : Int,
    @Column(name = "latitude")
    val latitude : Double,
    @Column(name = "longitude")
    val longitude : Double,
    @Column(name = "isAvailable")
    val isAvailable : Boolean,
    @Column("createdAt")
    val createdAt: Instant = Clock.System.now(),
    @Column("updatedAt")
    val updatedAt: Instant = Clock.System.now()
)
