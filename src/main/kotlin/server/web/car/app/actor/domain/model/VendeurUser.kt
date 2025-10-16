package server.web.car.app.actor.domain.model

import jakarta.validation.constraints.NotNull
import server.web.car.app.actor.domain.model.request.VendeurRequest
import server.web.car.app.user.domain.model.UserRequest

data class VendeurUser(
    @NotNull
    val user : UserRequest,
    @NotNull
    val vendeur: VendeurRequest
)
