package server.web.car.app.property.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import server.web.car.app.property.infrastructure.persistence.entity.PropertyFeatureEntity

interface PropertyFeatureRepository : JpaRepository<PropertyFeatureEntity, Long> {
}