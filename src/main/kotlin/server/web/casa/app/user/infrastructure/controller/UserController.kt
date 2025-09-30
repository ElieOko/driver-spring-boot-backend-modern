package server.web.casa.app.user.infrastructure.controller

import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import server.web.casa.app.user.application.UserService
import server.web.casa.app.user.domain.model.User
import server.web.casa.app.user.domain.model.UserAuth

@RestController
@RequestMapping("users")
class UserController(
    val userService : UserService
) {

    private val logger = LoggerFactory.getLogger(this::class.java)
    @GetMapping
    fun getListUser(): ResponseEntity<List<User>>{
        val data = userService.findAllUser()
        return ResponseEntity.ok().body(data)
    }

    @GetMapping("/{id}")
    fun getUser(
        @PathVariable("id") id : Long
    ) : ResponseEntity<User> {
        val data = userService.findIdUser(id)
        return ResponseEntity.ok().body(data)
    }

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable("id") id : Long,
        @RequestBody @Valid user : User
    ) : ResponseEntity<User> {
        val updated = userService.updateUser(id,user)
        return ResponseEntity.ok(updated)
    }

    @PostMapping("/register")
    fun register(
        @RequestBody @Valid user : User
    ){
       // : ResponseEntity<User>
       // val data = userService.createUser(user)
       // return ResponseEntity.status(HttpStatus.CREATED).body(data)
    }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable("id") id : Long
    ): ResponseEntity<Any>{
        return try {
            ResponseEntity.ok().build()
        } catch (e : NoSuchElementException){
            ResponseEntity.status(404).build()
        }
    }

    @PostMapping("/login")
    fun login(
        @RequestBody @Valid userAuth : UserAuth
    ){

    }

}