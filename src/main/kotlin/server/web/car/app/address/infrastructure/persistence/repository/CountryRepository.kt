package server.web.car.app.address.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import server.web.car.app.address.infrastructure.persistence.entity.CountryEntity

interface CountryRepository : JpaRepository<CountryEntity, Long> {
}