package server.web.casa.app.property.infrastructure.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping()
class PropertyFeatureController {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createFeature(){

    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFeature(){

    }
}