package server.web.car.app.actor.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import server.web.car.app.actor.infrastructure.persistence.entity.AcheteurEntity

interface AcheteurRepository : JpaRepository<AcheteurEntity,Long> {
}