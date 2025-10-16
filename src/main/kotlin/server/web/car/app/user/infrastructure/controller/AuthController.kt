package server.web.car.app.user.infrastructure.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import server.web.car.app.user.domain.model.User
import jakarta.validation.Valid
import org.springframework.context.annotation.Profile
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import server.web.car.app.address.application.service.CityService
import server.web.car.app.user.application.AuthService
import server.web.car.app.user.application.TypeAccountService
import server.web.car.app.user.domain.model.UserAuth
import server.web.car.app.user.domain.model.UserRequest
import server.web.car.route.auth.AuthRoute

const val ROUTE_REGISTER = AuthRoute.REGISTER
const val ROUTE_LOGIN = AuthRoute.LOGIN

@Tag(name = "Authentification", description = "Gestion des accès")
@RestController
@RequestMapping
@Profile("dev")
class AuthController(
    private val authService: AuthService,
    private val cityService: CityService,
    private val typeAccountService: TypeAccountService
) {
    @Operation(summary = "Création utilisateur")
    @PostMapping(ROUTE_REGISTER)
    fun register(
        @Valid @RequestBody user: UserRequest
    ): ResponseEntity<Map<String, Any?>> {
        val city = cityService.findByIdCity(user.cityId)
        val typeAccount = typeAccountService.findByIdTypeAccount(user.typeAccountId)
        if (city != null && typeAccount != null){
            val userSystem = User(
                userId = 0,
                username = user.username,
                password = user.password,
                typeAccount = typeAccount,
                email = user.email,
                phone = user.phone,
                city = city
            )
           val data = authService.register(userSystem)
           val response = mapOf(
               "user" to data.first,
               "token" to data.second,
               "message" to "Votre compte ${data.first?.typeAccount?.name} a été créer avec succès"
            )
           return ResponseEntity.status(201).body(response)
        }
        val response = mapOf("error" to "Erreur au niveau de la validation des données")
        return ResponseEntity.badRequest().body(response)
    }

    @Operation(summary = "Connexion utilisateur")
    @PostMapping(ROUTE_LOGIN)
    fun login(
      @Valid @RequestBody body: UserAuth
    ): ResponseEntity<Map<String, Any?>> {
      val data = authService.login(body.username, body.password)
      val response = mapOf(
          "user" to data.second,
          "token" to data.first.accessToken,
          "refresh_token" to data.first.refreshToken,
          "message" to "Connexion réussie avec succès"
      )
      return ResponseEntity.ok().body(response)
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