package server.web.casa.app.property.infrastructure.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import server.web.casa.route.property.PropertyRoute

const val ROUTE_PROPERTY_TYPE = PropertyRoute.PROPERTY_TYPE

@RestController
@RequestMapping(ROUTE_PROPERTY_TYPE)
class PropertyTypeController {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createType(){

    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllType(){

    }
}