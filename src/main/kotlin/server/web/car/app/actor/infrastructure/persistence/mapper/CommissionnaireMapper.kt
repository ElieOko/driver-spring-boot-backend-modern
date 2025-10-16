package server.web.car.app.actor.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.car.app.actor.domain.model.Commissionnaire
import server.web.car.app.actor.infrastructure.persistence.entity.CommissionnaireEntity
import server.web.car.app.user.infrastructure.persistence.mapper.UserMapper

@Component
class CommissionnaireMapper(
    private val userMapper: UserMapper,
    private val typeCardMapper: TypeCardMapper
) {
    fun toDomain(commissionnaireEntity: CommissionnaireEntity) : Commissionnaire{
            return Commissionnaire(
                commissionnaireId = commissionnaireEntity.commissionnaireId,
                firstName = commissionnaireEntity.firstName,
                lastName = commissionnaireEntity.lastName,
                fullName = commissionnaireEntity.fullName,
                address = commissionnaireEntity.address,
                images = commissionnaireEntity.images,
                cardFront = commissionnaireEntity.cardFront,
                cardBack = commissionnaireEntity.cardBack,
                user = userMapper.toDomain(commissionnaireEntity.user),
                typeCard = typeCardMapper.toDomain(commissionnaireEntity.typeCard),
                numberCard = commissionnaireEntity.numberCard
            )
    }

    fun toEntity(commissionnaire: Commissionnaire): CommissionnaireEntity {
            return CommissionnaireEntity(
                commissionnaireId = commissionnaire.commissionnaireId,
                firstName = commissionnaire.firstName,
                lastName = commissionnaire.lastName,
                fullName = commissionnaire.fullName,
                address = commissionnaire.address,
                images = commissionnaire.images,
                cardFront = commissionnaire.cardFront,
                cardBack = commissionnaire.cardBack,
                user = userMapper.toEntity(commissionnaire.user),
                typeCard = typeCardMapper.toEntity(commissionnaire.typeCard),
                numberCard = commissionnaire.numberCard
            )
    }
}