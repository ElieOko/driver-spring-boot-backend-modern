package server.web.casa.app.actor.application.service

import org.springframework.stereotype.Service
import server.web.casa.app.actor.domain.model.TypeCard
import server.web.casa.app.actor.infrastructure.persistence.mapper.TypeCardMapper
import server.web.casa.app.actor.infrastructure.persistence.repository.TypeCardRepository

@Service
class TypeCardService(
   private val repository: TypeCardRepository,
   private val mapper: TypeCardMapper
) {
    fun findByIdTypeCard(id : Long) : TypeCard? {
        val data = repository.findById(id).orElse(null)
        return mapper.toDomain(data)
    }
}