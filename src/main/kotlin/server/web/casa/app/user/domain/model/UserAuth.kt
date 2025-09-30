package server.web.casa.app.user.domain.model

import jakarta.validation.constraints.NotNull

data class UserAuth(
    @NotNull
    val username : String,
    @NotNull
    val password : String
)
