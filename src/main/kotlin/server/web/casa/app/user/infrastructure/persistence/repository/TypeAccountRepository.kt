package server.web.casa.app.user.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import server.web.casa.app.user.infrastructure.persistence.TypeAccountEntity

interface TypeAccountRepository : JpaRepository<TypeAccountEntity, Long> {
}