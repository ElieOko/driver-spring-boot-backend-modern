package server.web.car.app.actor.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.car.app.actor.domain.model.Acheteur
import server.web.car.app.actor.infrastructure.persistence.entity.AcheteurEntity
import server.web.car.app.user.infrastructure.persistence.mapper.UserMapper

@Component
class AcheteurMapper(
    private val userMapper: UserMapper,
    private val typeCardMapper: TypeCardMapper
) {
    fun toDomain(d: AcheteurEntity) : Acheteur{
            return Acheteur(
                acheteurId = d.acheteurId,
                firstName = d.firstName,
                lastName = d.lastName,
                fullName = d.fullName,
                address = d.address,
                images = d.images,
                cardFront = d.cardFront,
                cardBack = d.cardBack,
                user = userMapper.toDomain(d.user),
                typeCard = typeCardMapper.toDomain(d.typeCard),
                numberCard = d.numberCard
            )
    }

    fun toEntity(a: Acheteur): AcheteurEntity {
            return AcheteurEntity(
                acheteurId = a.acheteurId,
                firstName = a.firstName,
                lastName = a.lastName,
                fullName = a.fullName,
                address = a.address,
                images = a.images,
                cardFront = a.cardFront,
                cardBack = a.cardBack,
                user = userMapper.toEntity(a.user),
                typeCard = typeCardMapper.toEntity(a.typeCard),
                numberCard = a.numberCard
            )
    }
}