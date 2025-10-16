package server.web.car.app.actor.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.car.app.actor.domain.model.Vendeur
import server.web.car.app.actor.infrastructure.persistence.entity.VendeurEntity
import server.web.car.app.user.infrastructure.persistence.mapper.UserMapper

@Component
class VendeurMapper(
    private val userMapper: UserMapper,
    private val typeCardMapper: TypeCardMapper
) {
    fun toDomain(a: VendeurEntity) : Vendeur{
            return Vendeur(
                vendeurId = a.vendeurId,
                firstName = a.firstName,
                lastName = a.lastName,
                fullName = a.fullName,
                address = a.address,
                images = a.images,
                cardFront = a.cardFront,
                cardBack = a.cardBack,
                parrain = userMapper.toDomain(a.parrain),
                user = userMapper.toDomain(a.user),
                typeCard = typeCardMapper.toDomain(a.typeCard),
                numberCard = a.numberCard,
                note = a.note
            )
    }

    fun toEntity(a: Vendeur): VendeurEntity {
            return VendeurEntity(
                vendeurId = a.vendeurId,
                firstName = a.firstName,
                lastName = a.lastName,
                fullName = a.fullName,
                address = a.address,
                images = a.images,
                cardFront = a.cardFront,
                cardBack = a.cardBack,
                parrain = userMapper.toEntity(a.parrain),
                user = userMapper.toEntity(a.user),
                typeCard = typeCardMapper.toEntity(a.typeCard),
                numberCard = a.numberCard,
                note = a.note
            )
    }
}