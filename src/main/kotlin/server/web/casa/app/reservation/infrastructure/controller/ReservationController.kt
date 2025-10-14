package server.web.casa.app.reservation.infrastructure.controller

import jakarta.validation.Valid
import org.springframework.context.annotation.Profile
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

import server.web.casa.route.reservation.ReservationRoute
import server.web.casa.utils.Mode

const val ROUTE_RESERVATION = ReservationRoute.RESERVATION

@RestController
@RequestMapping(ROUTE_RESERVATION)
@Profile(Mode.DEV)

class ReservationController(){

}