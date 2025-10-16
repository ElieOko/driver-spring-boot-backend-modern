package server.web.car.app.user.domain.model

import jakarta.validation.constraints.NotNull

data class UserAuth(
    @NotNull
    val username : String,
    @NotNull
    val password : String
)
