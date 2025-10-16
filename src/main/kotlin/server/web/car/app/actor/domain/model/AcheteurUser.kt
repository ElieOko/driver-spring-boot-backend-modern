package server.web.car.app.actor.domain.model

import jakarta.validation.constraints.NotNull
import server.web.car.app.actor.domain.model.request.AcheteurRequest
import server.web.car.app.user.domain.model.UserRequest

data class AcheteurUser(
    @NotNull
    val user : UserRequest,
    @NotNull
    val acheteur : AcheteurRequest
)
