package server.web.casa.app.property.infrastructure.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import server.web.casa.route.property.PropertyRoute

const val ROUTE_PROPERTY_FEATURE = PropertyRoute.PROPERTY_FEATURE

@RestController
@RequestMapping(ROUTE_PROPERTY_FEATURE)
class PropertyFeatureController {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createFeature(){

    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFeature(){

    }
}