package server.web.car.app.address.infrastructure.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.context.annotation.Profile
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import server.web.car.app.address.application.service.CityService
import server.web.car.app.address.domain.model.City
import server.web.car.route.address.AddressRoute
import server.web.car.utils.Mode

const val ROUTE_CITY = AddressRoute.CITIES

@Tag(name = "City", description = "Gestion des villes")
@RestController
@RequestMapping(ROUTE_CITY)
@Profile(Mode.DEV)
class CityController(
   private val service : CityService
) {
    @Operation(summary = "Liste de villes")
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllCity(): ResponseEntity<Map<String, List<City>>> {
        val data = service.findAllCity()
        val response = mapOf("cities" to data)
        return ResponseEntity.ok().body(response)
    }
}