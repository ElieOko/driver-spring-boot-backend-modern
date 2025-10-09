package server.web.casa.app.address.infrastructure.controller

import org.springframework.context.annotation.Profile
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import server.web.casa.app.address.application.service.CityService
import server.web.casa.app.address.domain.model.City
import server.web.casa.route.address.AddressRoute
import server.web.casa.utils.Mode

const val ROUTE_CITY = AddressRoute.CITIES

@RestController
@RequestMapping(ROUTE_CITY)
@Profile(Mode.DEV)
class CityController(
   private val service : CityService
) {
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllCity(): ResponseEntity<Map<String, List<City>>> {
        val data = service.findAllCity()
        val response = mapOf("cities" to data)
        return ResponseEntity.ok().body(response)
    }
}