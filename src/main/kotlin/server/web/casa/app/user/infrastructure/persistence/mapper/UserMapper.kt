package server.web.casa.app.user.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.casa.app.address.infrastructure.persistence.mapper.CityMapper
import server.web.casa.app.user.domain.model.User
import server.web.casa.app.user.infrastructure.persistence.UserEntity
import kotlin.time.ExperimentalTime

@Component
class UserMapper(
    val mapperAccount : TypeAccountMapper,
    val mapperCity : CityMapper,
) {

    fun toDomain(entity: UserEntity) : User {
        return User(
            userId = entity.userId,
            username = entity.username,
            password = entity.password.toString(),
            typeAccount = mapperAccount.toDomain(entity.typeAccount) ,
            email = entity.email,
            phone = entity.phone,
            city = mapperCity.toDomain(entity.city)
        )
    }

    @OptIn(ExperimentalTime::class)
    fun toEntity(user: User) : UserEntity {
        return UserEntity(
            userId = user.userId,
            username = user.username,
            password = user.password,
            typeAccount =mapperAccount.toEntity(user.typeAccount) ,
            email = user.email,
            phone = user.phone,
            city = mapperCity.toEntity(user.city)
        )
    }
}