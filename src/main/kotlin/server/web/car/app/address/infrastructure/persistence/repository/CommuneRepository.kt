package server.web.car.app.address.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import server.web.car.app.address.infrastructure.persistence.entity.CommuneEntity

interface CommuneRepository : JpaRepository<CommuneEntity,Long>{

}