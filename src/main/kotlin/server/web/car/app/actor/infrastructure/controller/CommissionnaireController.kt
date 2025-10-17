package server.web.car.app.actor.infrastructure.controller

import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.context.annotation.Profile
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import server.web.car.app.actor.application.service.*
import server.web.car.app.actor.domain.model.*
import server.web.car.app.address.application.service.CityService
import server.web.car.app.user.application.*
import server.web.car.app.user.domain.model.*
import server.web.car.route.actor.ActorRoute
import server.web.car.utils.Mode

const val ROUTE_ACTOR_COMMISSIONNAIRE = ActorRoute.COMMISSIONNAIRE

@Tag(name = "Commissionnaire", description = "Gestion des commissionnaires")
@RestController
@RequestMapping(ROUTE_ACTOR_COMMISSIONNAIRE)
@Profile(Mode.DEV)
class CommissionnaireController(
   private val service : CommissionnaireService,
   private val authService: AuthService,
   private val cityService: CityService,
   private val typeAccountService: TypeAccountService,
   private val typeCardService: TypeCardService,
) {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createCommissionnaire(
        @Valid @RequestBody request: CommissionnaireUser
    ): ResponseEntity<Map<String, Any?>> {
        val city = cityService.findByIdCity(request.user.cityId)
        val typeAccount = typeAccountService.findByIdTypeAccount(request.user.typeAccountId)
        val typeCard = typeCardService.findByIdTypeCard(request.commissionnaire.typeCardId)
        if (city != null && typeAccount != null && typeCard != null) {
            val userSystem = User(
                userId = 0,
                username = request.user.username,
                password = request.user.password,
                typeAccount = typeAccount,
                email = request.user.email,
                phone = request.user.phone,
                city = city
            )
            val userCreated = authService.register(userSystem)
            val data = Commissionnaire(
                firstName = request.commissionnaire.firstName,
                lastName = request.commissionnaire.lastName,
                fullName = "${request.commissionnaire.firstName} ${request.commissionnaire.lastName}",
                address = request.commissionnaire.address,
                images = request.commissionnaire.images,
                cardFront = request.commissionnaire.cardFront,
                cardBack = request.commissionnaire.cardBack,
                user = userCreated.first,
                typeCard = typeCard,
                numberCard = request.commissionnaire.numberCard
            )
            val bailleutCreated = service.createCommissionnaire(data)
            val response = mapOf(
                "message" to "Votre compte ${userCreated.first?.typeAccount?.name} a été créer avec succès",
                "user" to userCreated.first,
                "commissionnaire" to bailleutCreated,
                "token" to userCreated.second
            )
            return ResponseEntity.status(201).body(response)
        }
        val response = mapOf("error" to "Erreur au niveau de la validation des données")
        return ResponseEntity.badRequest().body(response)
    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllCommissionnaire(): ResponseEntity<Map<String, List<Commissionnaire>>> {
        val data = service.findAllCommissionnaire()
        val response = mapOf("commissionnaires" to data)
        return ResponseEntity.ok().body(response)
    }
}