package server.web.casa.app.address.domain.model

data class Commune(
    val communeId   : Int,
    val district  : District,
    val name        : String,
//    val quartier : Quartier
)
