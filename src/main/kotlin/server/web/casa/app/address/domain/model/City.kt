package server.web.casa.app.address.domain.model

import server.web.casa.app.user.domain.model.User

data class City(
    val cityId : Int,
    val country : Country,
    val name : String,
//    val user: User
)
