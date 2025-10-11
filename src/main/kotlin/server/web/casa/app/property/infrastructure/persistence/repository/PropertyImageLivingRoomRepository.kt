package server.web.casa.app.property.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyImageLivingRoomEntity

interface PropertyImageLivingRoomRepository : JpaRepository<PropertyImageLivingRoomEntity, Long> {
}