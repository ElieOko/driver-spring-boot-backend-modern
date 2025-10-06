package server.web.casa.app.actor.domain.model

import jakarta.validation.constraints.NotNull
import server.web.casa.app.user.domain.model.UserRequest

data class BailleurUser(
    @NotNull
    val user : UserRequest,
    @NotNull
    val bailleur: BailleurRequest
)
