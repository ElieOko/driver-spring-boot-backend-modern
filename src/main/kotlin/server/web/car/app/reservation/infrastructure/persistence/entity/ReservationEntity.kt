package server.web.car.app.reservation.infrastructure.persistence.entity

import jakarta.persistence.*
import server.web.car.app.property.infrastructure.persistence.entity.PropertyEntity
import server.web.car.app.reservation.domain.model.ReservationStatus
import server.web.car.app.reservation.domain.model.ReservationType
import server.web.car.app.user.infrastructure.persistence.entity.UserEntity
import java.time.LocalDate

@Table(name = "reservations")
@Entity
data class ReservationEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val reservationId       : Long,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn("propertyId")
    val property            : PropertyEntity,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn("userId")
    val user                : UserEntity,
    @Column(name = "message", nullable = true)
    val message             : String? = "",
    @Column(name = "reservationHeure", nullable = true)
    val reservationHeure    : String? = "",
    @Column(name = "status")
    val status              : ReservationStatus = ReservationStatus.PENDING,
    @Column("type_reservation")
    val type                : ReservationType = ReservationType.STANDARD,
    @Column(name = "isActive")
    val isActive            : Boolean = true,
    @Column(name = "cancellationReason", nullable = true)
    val cancellationReason  : String? = "",
    @Column(name = "startDate")
    val startDate           : LocalDate,
    @Column(name = "endDate")
    val endDate             : LocalDate,
    @Column("createdAt")
    val createdAt           : LocalDate = LocalDate.now(),
)
