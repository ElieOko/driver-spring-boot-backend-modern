package server.web.car.app.actor.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.car.app.actor.domain.model.TypeCard
import server.web.car.app.actor.infrastructure.persistence.entity.TypeCardEntity

@Component
class TypeCardMapper {
    fun toDomain(typeCardEntity: TypeCardEntity) : TypeCard{
        return TypeCard(
            typeCardId = typeCardEntity.typeCardId,
            name = typeCardEntity.name,
        )
    }
    
    fun toEntity(typeCard: TypeCard? = null): TypeCardEntity {
        return TypeCardEntity(
            typeCardId = typeCard!!.typeCardId,
            name = typeCard.name
        )
    }
}