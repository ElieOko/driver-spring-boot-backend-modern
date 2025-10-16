package server.web.car.app.address.domain.model

data class Commune(
    val communeId   : Long = 0,
    val district  : District? = null,
    val name        : String
)
