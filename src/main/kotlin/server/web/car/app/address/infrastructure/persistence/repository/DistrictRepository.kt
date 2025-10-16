package server.web.car.app.address.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import server.web.car.app.address.infrastructure.persistence.entity.DistrictEntity

interface DistrictRepository : JpaRepository<DistrictEntity, Long> {
}