package server.web.casa.app.user.application

import server.web.casa.app.user.domain.model.UserAuth
import server.web.casa.app.user.domain.model.User
import server.web.casa.app.user.infrastructure.persistence.UserEntity
import server.web.casa.app.user.infrastructure.persistence.UserMapper
import server.web.casa.app.user.infrastructure.persistence.UserRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import kotlin.time.ExperimentalTime

@Service
class UserService(
    private val repository: UserRepository,
    private val mapper: UserMapper
) {
    val name = "utilisateur"
    @OptIn(ExperimentalTime::class)
    fun createUser(user: User) : User {
        val entityToSave = UserEntity(
            userId = 0,
            username = user.username,
            password = user.password,
            typeAccountId = user.typeAccountId,
            email = user.email,
            phone = user.phone,
            cityId = user.cityId
        )
        val savedEntity = repository.save(entityToSave)
        return mapper.toDomain(savedEntity)
    }

    fun findAllUser() : List<User> {
        val allEntityUser = repository.findAll()
        return allEntityUser.stream().map {
            mapper.toDomain(it)
        }.toList()
    }

    fun findIdUser(id : Long) : User{
        val userEntity = repository.findById(id).orElseThrow{->
            EntityNotFoundException("Aucun $name avec cet identifiant $id")
        }
        return mapper.toDomain(userEntity)
    }

    @OptIn(ExperimentalTime::class)
    fun updateUser(
        id : Long,
        user : User
    ): User ?{
        val userEntity = repository.findById(id).orElseThrow{->
            EntityNotFoundException("Aucun $name avec cet identifiant $id")
        }
        val entityToUpdate = UserEntity(
            userId = user.userId,
            username = user.username,
            password = user.password,
            typeAccountId = user.typeAccountId,
            email = user.email,
            phone = user.phone,
            cityId = user.cityId
        )
        val updatedUser = repository.save(entityToUpdate)

        return mapper.toDomain(updatedUser)
    }

    fun deleteUser(id : Long){
        if (!repository.existsById(id)){
            EntityNotFoundException("Aucun $name avec cet identifiant $id")
        }
        repository.deleteById(id)
    }

    fun login(userAuth : UserAuth) : User? {
        return null
    }

}