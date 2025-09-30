package server.web.casa.app.address.domain.model

data class Quartier(
    val quartierId  : Int,
    val commune   : Commune,
    val name        : String,
)
