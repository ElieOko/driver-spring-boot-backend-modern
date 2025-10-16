package server.web.car.app.address.application.service

import org.springframework.stereotype.Service
import server.web.car.app.address.domain.model.Commune
import server.web.car.app.address.infrastructure.persistence.mapper.CommuneMapper
import server.web.car.app.address.infrastructure.persistence.repository.CommuneRepository

@Service
class CommuneService(
    private val repository: CommuneRepository,
    private val mapper : CommuneMapper
) {
    fun saveCommune(data: Commune): Commune {
        val data = mapper.toEntity(data)
        val result = repository.save(data)
        return mapper.toDomain(result)
    }

    fun findAllCommune() : List<Commune>{
        val allEntity = repository.findAll()
        return allEntity.stream().map {
            mapper.toDomain(it)
        }.toList()
    }

    fun findByIdCommune(id : Long) : Commune? {
        val data = repository.findById(id).orElse(null)
        return mapper.toDomain(data)
    }
}