package server.web.casa.app.property.infrastructure.controller

import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import server.web.casa.app.address.application.service.CityService
import server.web.casa.app.property.application.service.*
import server.web.casa.app.property.domain.model.Property
import server.web.casa.app.property.domain.model.request.PropertyRequest
import server.web.casa.app.user.application.UserService
import server.web.casa.app.user.infrastructure.controller.RefreshRequest
import server.web.casa.route.property.PropertyRoute

const val ROUTE_PROPERTY = PropertyRoute.PROPERTY
@RestController
@RequestMapping(ROUTE_PROPERTY)
class PropertyController(
    private val service : PropertyService,
    private val propertyTypeService: PropertyTypeService,
    private val cityService: CityService,
    private val userService: UserService,
    private val propertyImageService: PropertyImageService,
    private val propertyImageLivingRoomService: PropertyImageLivingRoomService,
    private val propertyImageRoomService: PropertyImageRoomService,
    private val propertyImageKitchenService: PropertyImageKitchenService,
) {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createProperty(
        @Valid @RequestBody request: PropertyRequest
    ){
       val imageList = request.propertyImage
       val imageKitchen = request.propertyImageKitchen
       val imageRoom = request.propertyImageRoom
       val imageLivingRoom = request.propertyImageLivingRoom
       val city = cityService.findByIdCity(request.cityId)
       val user = userService.findIdUser(request.userId)
       val propertyType = propertyTypeService.findByIdPropertyType(request.propertyTypeId)
        if (city != null && user != null){
            val property = Property(
                title = request.title,
                description = request.description,
                price = request.price,
                surface = request.surface,
                rooms = request.rooms,
                bedrooms = request.bedrooms,
                kitchen = request.kitchen,
                livingRoom = request.livingRoom,
                bathroom = request.bathroom,
                floor = request.floor,
                address = request.address,
                city = city,
                postalCode = request.postalCode,
                commune = ,
                quartier = request.quartier,
                sold = request.sold,
                transactionType = request.transactionType,
                propertyType = propertyType,
                user = user,
                latitude = request.latitude,
                longitude = request.longitude
            )
        }

    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllProperty(){

    }
}