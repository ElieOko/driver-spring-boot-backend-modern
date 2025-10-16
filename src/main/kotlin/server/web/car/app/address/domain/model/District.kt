package server.web.car.app.address.domain.model

data class District(
    val districtId : Long = 0,
    val city   : City,
    val name   : String
)
