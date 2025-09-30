package server.web.casa.app.user.infrastructure.controller


import server.web.casa.app.user.domain.model.User
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import server.web.casa.app.user.application.AuthService
import server.web.casa.app.user.domain.model.UserAuth

@RestController
@RequestMapping
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/register")
    fun register(
        @Valid @RequestBody user: User
    ) {
        authService.register(user)
    }

    @PostMapping("/login")
    fun login(
        @RequestBody body: UserAuth
    ): AuthService.TokenPair {
        return authService.login(body.username, body.password)
    }

    @PostMapping("/refresh")
    fun refresh(
        @RequestBody body: RefreshRequest
    ): AuthService.TokenPair {
        return authService.refresh(body.refreshToken)
    }
}

data class RefreshRequest(
    val refreshToken: String
)