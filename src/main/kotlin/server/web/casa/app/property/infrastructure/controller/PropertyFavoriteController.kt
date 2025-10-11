package server.web.casa.app.property.infrastructure.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping()
class PropertyFavoriteController {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createFavorite(){

    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllFavoriteByUser(){

    }
}