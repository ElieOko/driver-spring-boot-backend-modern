package server.web.car.app.actor.application.service

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import server.web.car.app.actor.domain.model.Acheteur
import server.web.car.app.actor.infrastructure.persistence.mapper.AcheteurMapper
import server.web.car.app.actor.infrastructure.persistence.repository.AcheteurRepository
import server.web.car.utils.Mode

@Service
@Profile(Mode.DEV)
class AcheteurService(
    private val repository: AcheteurRepository,
    private val mapper: AcheteurMapper
) {
    fun create(a: Acheteur): Acheteur {
        val data = mapper.toEntity(a)
        val result = repository.save(data)
       return mapper.toDomain(result)
    }

    fun findAll() : List<Acheteur> {
        val allEntity = repository.findAll()
        return allEntity.stream().map {
            mapper.toDomain(it)
        }.toList()
    }
}