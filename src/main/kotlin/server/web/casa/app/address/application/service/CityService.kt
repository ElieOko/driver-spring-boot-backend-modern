package server.web.casa.app.address.application.service

import org.springframework.stereotype.Service
import server.web.casa.app.address.domain.model.City
import server.web.casa.app.address.infrastructure.persistence.mapper.CityMapper
import server.web.casa.app.address.infrastructure.persistence.repository.CityRepository

@Service
class CityService(
    private val repository: CityRepository,
    private val mapper: CityMapper
) {
    fun findAllCity() : List<City>{
        val allEntity = repository.findAll()
        return allEntity.stream().map {
            mapper.toDomain(it)
        }.toList()
    }
}