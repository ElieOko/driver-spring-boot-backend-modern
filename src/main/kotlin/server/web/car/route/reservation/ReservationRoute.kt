package server.web.car.route.reservation

import server.web.car.route.GlobalRoute

object ReservationRoute {
    const val RESERVATION = "${GlobalRoute.ROOT}/${ReservationFeatures.RESERVATION_PATH}"
}

object ReservationFeatures{
    const val RESERVATION_PATH = "reservations"
}