package server.web.car.app.reservation.infrastructure.controller

import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.*

import server.web.car.route.reservation.ReservationRoute
import server.web.car.utils.Mode

const val ROUTE_RESERVATION = ReservationRoute.RESERVATION

@RestController
@RequestMapping(ROUTE_RESERVATION)
@Profile(Mode.DEV)

class ReservationController(){

}