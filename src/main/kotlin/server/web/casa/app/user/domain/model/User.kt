package server.web.casa.app.user.domain.model

import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import java.time.LocalDateTime

data class User(
    @Null
    val userId        : Long,
    @NotNull
    val username      : String,
    @NotNull
    val password      : String,
    val typeAccountId : Long,
    @Null
    val email         : String? = null,
    @Null
    val phone         : String,
    val cityId        : Long,
    @FutureOrPresent
    @Null
    val createdStart : LocalDateTime? = null
)
