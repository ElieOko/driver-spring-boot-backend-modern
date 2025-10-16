package server.web.car.app.reservation.domain.model

import server.web.car.app.property.domain.model.Property
import server.web.car.app.user.domain.model.User
import java.time.LocalDate

data class Reservation(
    val reservationId: Long,
    val user: User?,
    val property: Property,
    val message: String? = "",
    val status: ReservationStatus = ReservationStatus.PENDING,
    val type: ReservationType = ReservationType.STANDARD,
    val isActive: Boolean = true,
    val reservationHeure: String? = "",
    val cancellationReason: String? = "",
    val startDate: LocalDate,
    val endDate: LocalDate,
    val createdAt: LocalDate = LocalDate.now(),
)
