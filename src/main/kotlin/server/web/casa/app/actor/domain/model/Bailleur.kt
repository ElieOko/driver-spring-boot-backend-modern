package server.web.casa.app.actor.domain.model

import server.web.casa.app.user.domain.model.User

data class Bailleur(
    val id : Long,
    val firstName   : String,
    val lastName    : String,
    val fullName    : String,
    val address     : String,
    val images      : String,
    val cardFront   : String,
    val cardBack    : String,
    val parrainId   : User? = null,
    val user         : User,
    val typeCardId  : Int,
    val numberCard  : String? = null,
    val note        : String? = null
)

data class BailleurRequest(
    val lastName: String,
    val firstName: String,
    val address : String,
    val images : String,
    val cardFront : String,
    val cardBack : String,
    val parrainId : Long? = null,
    val numberCard : String? = null,
    val note : String? = null
)