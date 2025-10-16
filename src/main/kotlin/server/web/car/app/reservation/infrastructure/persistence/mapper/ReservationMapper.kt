package server.web.car.app.reservation.infrastructure.persistence.mapper

import server.web.car.app.property.infrastructure.persistence.mapper.PropertyMapper
import server.web.car.app.reservation.domain.model.Reservation
import server.web.car.app.reservation.infrastructure.persistence.entity.ReservationEntity
import server.web.car.app.user.infrastructure.persistence.mapper.UserMapper

class ReservationMapper(
    private val userMapper : UserMapper,
    private val propertyMapper: PropertyMapper
) {
    fun toDomain(reservationEntity : ReservationEntity): Reservation {
        return Reservation(
            reservationId = reservationEntity.reservationId,
            user = userMapper.toDomain(reservationEntity.user),
            message = reservationEntity.message,
            status = reservationEntity.status,
            type = reservationEntity.type,
            isActive = reservationEntity.isActive,
            reservationHeure = reservationEntity.reservationHeure,
            cancellationReason = reservationEntity.cancellationReason,
            startDate = reservationEntity.startDate,
            endDate = reservationEntity.endDate,
            createdAt = reservationEntity.createdAt,
            property = propertyMapper.toDomain(reservationEntity.property)
        )
    }

    fun toEntity(reservation : Reservation): ReservationEntity {
        return ReservationEntity(
            reservationId = reservation.reservationId,
            user = userMapper.toEntity(reservation.user)!!,
            property = propertyMapper.toEntity(reservation.property),
            message = reservation.message,
            status = reservation.status,
            type = reservation.type,
            isActive = reservation.isActive,
            reservationHeure = reservation.reservationHeure,
            cancellationReason = reservation.cancellationReason,
            startDate = reservation.startDate,
            endDate = reservation.endDate,
            createdAt = reservation.createdAt
        )

    }
}