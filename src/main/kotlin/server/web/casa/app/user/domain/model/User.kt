package server.web.casa.app.user.domain.model

import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import server.web.casa.app.address.domain.model.City
import java.time.LocalDateTime

data class User(
    @Null
    val userId        : Long,
    @NotNull
    val username      : String,
    @NotNull
    val password      : String,
    val typeAccount   : TypeAccount? = null,
    @Null
    val email         : String? = null,
    @Null
    val phone         : String,
    val city        : City? = null,
    @FutureOrPresent
    @Null
    val createdStart : LocalDateTime? = null
)
