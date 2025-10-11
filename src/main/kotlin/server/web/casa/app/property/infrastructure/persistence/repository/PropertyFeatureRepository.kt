package server.web.casa.app.property.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyFeatureEntity

interface PropertyFeatureRepository : JpaRepository<PropertyFeatureEntity, Long> {
}