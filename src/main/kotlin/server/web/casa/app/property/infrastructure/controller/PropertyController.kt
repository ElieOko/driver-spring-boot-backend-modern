package server.web.casa.app.property.infrastructure.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import server.web.casa.app.property.application.service.*
import server.web.casa.route.property.PropertyRoute

const val ROUTE_PROPERTY = PropertyRoute.PROPERTY
@RestController
@RequestMapping(ROUTE_PROPERTY)
class PropertyController(
    private val service : PropertyService,
    private val propertyTypeService: PropertyTypeService,
    private val propertyImageService: PropertyImageService,
    private val propertyImageLivingRoomService: PropertyImageLivingRoomService,
    private val propertyImageRoomService: PropertyImageRoomService,
    private val propertyImageKitchenService: PropertyImageKitchenService,
) {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createProperty(){

    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllProperty(){

    }
}