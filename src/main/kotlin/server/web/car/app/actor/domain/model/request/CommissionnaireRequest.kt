package server.web.car.app.actor.domain.model.request

import jakarta.validation.constraints.NotNull

data class CommissionnaireRequest(
    @NotNull
    val lastName: String,
    @NotNull
    val firstName: String,
    val address : String = "",
    val images : String="",
    val cardFront : String="",
    val cardBack : String="",
    val typeCardId : Long,
    val numberCard : String = ""
)
