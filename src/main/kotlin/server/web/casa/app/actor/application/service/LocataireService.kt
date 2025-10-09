package server.web.casa.app.actor.application.service

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import server.web.casa.app.actor.domain.model.Locataire
import server.web.casa.app.actor.infrastructure.persistence.mapper.LocataireMapper
import server.web.casa.app.actor.infrastructure.persistence.repository.LocataireRepository
import server.web.casa.utils.Mode

@Service
@Profile(Mode.DEV)
class LocataireService(
    private val repository: LocataireRepository,
    private val mapper: LocataireMapper
) {
    fun createLocataire(locataire: Locataire): Locataire {
        val data = mapper.toEntity(locataire)
        val result = repository.save(data)
       return mapper.toDomain(result)
    }

    fun findAllLocataire() : List<Locataire> {
        val allEntity = repository.findAll()
        return allEntity.stream().map {
            mapper.toDomain(it)
        }.toList()
    }
}