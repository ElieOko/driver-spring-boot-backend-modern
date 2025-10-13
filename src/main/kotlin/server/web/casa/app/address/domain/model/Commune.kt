package server.web.casa.app.address.domain.model

data class Commune(
    val communeId   : Long,
    val district  : District? = null,
    val name        : String,
//    val quartier : Quartier
)
