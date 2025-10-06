package server.web.casa.route.auth

import server.web.casa.route.GlobalRoute
import server.web.casa.utils.locationApi

object AuthRoute {
    val register = locationApi(GlobalRoute.auth,AuthFeatures.REGISTER.name)
    val login = locationApi(GlobalRoute.auth,AuthFeatures.LOGIN.name)
    val resetPassword = locationApi(GlobalRoute.auth,AuthFeatures.RESET_PASSWORD.name)
}

enum class AuthFeatures{
    LOGIN,
    REGISTER,
    RESET_PASSWORD
}