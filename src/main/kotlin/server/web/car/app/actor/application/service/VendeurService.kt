package server.web.car.app.actor.application.service

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import server.web.car.app.actor.domain.model.Vendeur
import server.web.car.app.actor.infrastructure.persistence.mapper.VendeurMapper
import server.web.car.app.actor.infrastructure.persistence.repository.VendeurRepository
import server.web.car.utils.Mode

@Service
@Profile(Mode.DEV)
class VendeurService(
    private val repository: VendeurRepository,
    private val mapper: VendeurMapper
) {
    fun create(a: Vendeur): Vendeur {
        val data = mapper.toEntity(a)
        val result = repository.save(data)
       return mapper.toDomain(result)
    }

    fun findAll() : List<Vendeur> {
        val allEntity = repository.findAll()
        return allEntity.stream().map {
            mapper.toDomain(it)
        }.toList()
    }
}