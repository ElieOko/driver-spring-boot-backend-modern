package server.web.casa.app.actor.application.service

import org.springframework.stereotype.Service
import server.web.casa.app.actor.domain.model.Bailleur
import server.web.casa.app.actor.infrastructure.persistence.entity.BailleurEntity
import server.web.casa.app.actor.infrastructure.persistence.mapper.BailleurMapper
import server.web.casa.app.actor.infrastructure.persistence.repository.BailleurRepository
import server.web.casa.app.address.domain.model.City

@Service
class BailleurService(
    private val repository: BailleurRepository,
    private val mapper: BailleurMapper
) {
    fun createBailleur(bailleur: Bailleur): Bailleur {
        val data = mapper.toEntity(bailleur)
        val result = repository.save(data)
       return mapper.toDomain(result)
    }

    fun findAllBailleur() : List<Bailleur> {
        val allEntity = repository.findAll()
        return allEntity.stream().map {
            mapper.toDomain(it)
        }.toList()
    }
}