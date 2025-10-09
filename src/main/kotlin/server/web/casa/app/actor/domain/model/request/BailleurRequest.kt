package server.web.casa.app.actor.domain.model.request

import jakarta.validation.constraints.NotNull

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
