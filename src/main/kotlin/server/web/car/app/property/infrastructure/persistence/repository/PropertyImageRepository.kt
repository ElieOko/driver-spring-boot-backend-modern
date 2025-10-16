package server.web.car.app.property.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import server.web.car.app.property.infrastructure.persistence.entity.PropertyImageEntity

interface PropertyImageRepository : JpaRepository<PropertyImageEntity, Long> {
}