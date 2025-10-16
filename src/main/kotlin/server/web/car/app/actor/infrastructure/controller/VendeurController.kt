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
import server.web.car.app.user.domain.model.User
import server.web.car.route.actor.ActorRoute
import server.web.car.utils.Mode

const val ROUTE_ACTOR_vendeur = ActorRoute.LOCATAIRE

@Tag(name = "Vendeur", description = "Gestion des vendeurs")
@RestController
@RequestMapping(ROUTE_ACTOR_vendeur)
@Profile(Mode.DEV)
class VendeurController(
    private val service : VendeurService,
    private val authService: AuthService,
    private val userService: UserService,
    private val cityService: CityService,
    private val typeAccountService: TypeAccountService,
    private val typeCardService: TypeCardService,
) {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(
        @Valid @RequestBody request: VendeurUser
    ): ResponseEntity<Map<String, Any?>> {
        val city = cityService.findByIdCity(request.user.cityId)
        val typeAccount = typeAccountService.findByIdTypeAccount(request.user.typeAccountId)
        val typeCard = typeCardService.findByIdTypeCard(request.vendeur.typeCardId)
        var parrain : User? = null

        if (city != null && typeAccount != null && typeCard != null) {
            if (request.vendeur.parrainId != null){
                parrain = userService.findIdUser(request.vendeur.parrainId)
            }
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
            val data = Vendeur(
                firstName = request.vendeur.firstName,
                lastName = request.vendeur.lastName,
                fullName = "${request.vendeur.firstName} ${request.vendeur.lastName}",
                address = request.vendeur.address,
                images = request.vendeur.images,
                cardFront = request.vendeur.cardFront,
                cardBack = request.vendeur.cardBack,
                parrain = parrain,
                user = userCreated.first,
                typeCard = typeCard,
                numberCard = request.vendeur.numberCard,
                note = request.vendeur.note
            )
            val bailleutCreated = service.create(data)
            val response = mapOf(
                "message" to "Votre compte ${userCreated.first?.typeAccount?.name} a été créer avec succès",
                "user" to userCreated.first,
                "vendeur" to bailleutCreated,
                "token" to userCreated.second
            )
            return ResponseEntity.status(201).body(response)
        }
        val response = mapOf("error" to "Erreur au niveau de la validation des données")
        return ResponseEntity.badRequest().body(response)
    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllvendeur(): ResponseEntity<Map<String, List<Vendeur>>> {
        val data = service.findAll()
        val response = mapOf("vendeurs" to data)
        return ResponseEntity.ok().body(response)
    }
}