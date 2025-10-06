package server.web.casa.app.user.infrastructure.controller

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import server.web.casa.app.user.application.TypeAccountService
import server.web.casa.app.user.domain.model.TypeAccount

@RestController
@RequestMapping("api/account")
class TypeAccountController(
    private val service: TypeAccountService
) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getListTypeAccount(): ResponseEntity<Map<String, List<TypeAccount>>> {
        val data = service.getAll()
        val mapResponse = mapOf("type_accounts" to data)
        return ResponseEntity.ok().body(mapResponse)
    }
}