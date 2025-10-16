package server.web.car.app.actor.domain.model

import server.web.car.app.user.domain.model.User

data class Acheteur(
    val acheteurId: Long = 0,
    val firstName  : String,
    val lastName   : String,
    val fullName   : String,
    val address    : String,
    val images     : String,
    val cardFront  : String,
    val cardBack   : String,
    val user       : User?,
    val typeCard   : TypeCard,
    val numberCard : String? = null
)
