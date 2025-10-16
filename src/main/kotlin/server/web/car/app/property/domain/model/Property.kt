package server.web.car.app.property.domain.model

import server.web.car.app.address.domain.model.*
import server.web.car.app.user.domain.model.User
import java.time.LocalDate

data class Property(
    val propertyId : Long = 0,
    val title : String,
    val description : String? = "",
    val price : Double,
    val surface : Double? = null,
    val rooms : Int? = 0,
    val bedrooms : Int? = 0,
    val kitchen : Int? = 0,
    val livingRoom : Int? = 0,
    val bathroom : Int? = 0,
    val floor : Int? = 0,
    val address : String,
    val city : City,
    val postalCode : String? = "",
    val commune : Commune,
    val quartier : String,
    val sold : Boolean,
    val transactionType : String,
    val propertyType : PropertyType,
    val user : User?,
    val latitude : Double? = null,
    val longitude : Double? = null,
    val isAvailable : Boolean = true,
    val features : List<PropertyFeature> = emptyList(),
    val favorites : List<PropertyFavorite?> = emptyList(),
    val propertyImage : List<PropertyImage> = emptyList(),
    val propertyImageRoom : List<PropertyImageRoom> = emptyList(),
    val propertyImageLivingRoom : List<PropertyImageLivingRoom> = emptyList(),
    val propertyImageKitchen : List<PropertyImageKitchen> = emptyList(),
    val createdAt: LocalDate = LocalDate.now(),
    val updatedAt: LocalDate = LocalDate.now(),
)
