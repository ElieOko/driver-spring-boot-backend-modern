package server.web.casa.app.user.infrastructure.persistence

import server.web.casa.app.user.domain.model.User
import org.springframework.stereotype.Component
import kotlin.time.ExperimentalTime

@Component
class UserMapper {
    fun toDomain(entity: UserEntity) : User {
        return User(
            userId = entity.userId,
            username = entity.username,
            password = entity.password.toString(),
            typeAccountId = entity.typeAccountId,
            email = entity.email,
            phone = entity.phone,
            cityId = entity.cityId
        )
    }

    @OptIn(ExperimentalTime::class)
    fun toEntity(user: User) : UserEntity {
        return UserEntity(
            userId = user.userId,
            username = user.username,
            password = user.password,
            typeAccountId = user.typeAccountId,
            email = user.email,
            phone = user.phone,
            cityId = user.cityId
        )
    }
}