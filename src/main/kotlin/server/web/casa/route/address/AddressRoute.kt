package server.web.casa.route.address

import server.web.casa.route.GlobalRoute

object AddressRoute {
    const val CITIES = "${GlobalRoute.ROOT}/${AddressFeatures.CITIES_PATH}"
    const val COUNTRIES = "${GlobalRoute.ROOT}/${AddressFeatures.COUNTRIES_PATH}"
    const val COMMUNES = "${GlobalRoute.ROOT}/${AddressFeatures.COMMUNES_PATH}"
    const val DISTRICTS = "${GlobalRoute.ROOT}/${AddressFeatures.DISTRICTS_PATH}"
    const val QUARTIERS = "${GlobalRoute.ROOT}/${AddressFeatures.QUARTIERS_PATH}"
}

object AddressFeatures {
    const val CITIES_PATH = "cities"
    const val COUNTRIES_PATH = "countries"
    const val COMMUNES_PATH = "communes"
    const val DISTRICTS_PATH = "districs"
    const val QUARTIERS_PATH = "quartiers"
}