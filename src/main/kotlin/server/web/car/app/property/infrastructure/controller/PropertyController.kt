package server.web.car.app.property.infrastructure.controller

import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import server.web.car.app.address.application.service.*
import server.web.car.app.property.application.service.*
import server.web.car.app.property.domain.model.Property
import server.web.car.app.property.domain.model.request.PropertyRequest
import server.web.car.app.user.application.UserService
import server.web.car.route.property.PropertyRoute

const val ROUTE_PROPERTY = PropertyRoute.PROPERTY

@Tag(name = "Property", description = "Gestion des propriètés")
@RestController
@RequestMapping(ROUTE_PROPERTY)
class PropertyController(
    private val service : PropertyService,
    private val propertyTypeService: PropertyTypeService,
    private val cityService: CityService,
    private val userService: UserService,
    private val communeService: CommuneService,
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
       val commune = communeService.findByIdCommune(request.communeId)
        if (city != null && user != null && commune != null && propertyType != null){
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
                commune = commune,
                quartier = request.quartier,
                sold = request.sold,
                transactionType = request.transactionType,
                propertyType = propertyType,
                user = user,
                latitude = request.latitude,
                longitude = request.longitude
            )
            service.create(property)
        }
    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllProperty(){

    }
}