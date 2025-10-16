package server.web.car.app.actor.domain.model

import jakarta.validation.constraints.NotNull
import server.web.car.app.actor.domain.model.request.CommissionnaireRequest
import server.web.car.app.user.domain.model.UserRequest

data class CommissionnaireUser(
    @NotNull
    val user : UserRequest,
    @NotNull
    val commissionnaire: CommissionnaireRequest
)