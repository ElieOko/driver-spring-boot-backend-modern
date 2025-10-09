package server.web.casa.app.actor.application.service

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import server.web.casa.app.actor.domain.model.Commissionnaire
import server.web.casa.app.actor.infrastructure.persistence.mapper.CommissionnaireMapper
import server.web.casa.app.actor.infrastructure.persistence.repository.CommissionnaireRepository
import server.web.casa.utils.Mode

@Service
@Profile(Mode.DEV)
class CommissionnaireService(
    private val repository: CommissionnaireRepository,
    private val mapper: CommissionnaireMapper
) {
    fun createCommissionnaire(commissionnaire: Commissionnaire): Commissionnaire {
        val data = mapper.toEntity(commissionnaire)
        val result = repository.save(data)
       return mapper.toDomain(result)
    }

    fun findAllCommissionnaire() : List<Commissionnaire> {
        val allEntity = repository.findAll()
        return allEntity.stream().map {
            mapper.toDomain(it)
        }.toList()
    }
}