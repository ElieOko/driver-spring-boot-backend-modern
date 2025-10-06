package server.web.casa.app.actor.domain.model

import jakarta.validation.constraints.NotNull
import server.web.casa.app.user.domain.model.User

data class Bailleur(
    val bailleurId : Long = 0,
    val firstName  : String,
    val lastName   : String,
    val fullName   : String,
    val address    : String,
    val images     : String,
    val cardFront  : String,
    val cardBack   : String,
    val parrain    : User? = null,
    val user       : User?,
    val typeCard   : TypeCard,
    val numberCard : String? = null,
    val note       : String? = null
)

data class BailleurRequest(
    @NotNull
    val lastName: String,
    @NotNull
    val firstName: String,
    val address : String,
    @NotNull
    val images : String,
    @NotNull
    val cardFront : String,
    @NotNull
    val cardBack : String,
    val parrainId : Long? = null,
    val typeCardId : Long,
    @NotNull
    val numberCard : String? = null,
    val note : String? = null
)