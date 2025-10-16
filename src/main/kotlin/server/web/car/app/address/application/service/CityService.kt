package server.web.car.app.address.application.service

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import server.web.car.app.address.domain.model.City
import server.web.car.app.address.infrastructure.persistence.mapper.CityMapper
import server.web.car.app.address.infrastructure.persistence.repository.CityRepository
import server.web.car.utils.Mode

@Service
@Profile(Mode.DEV)
class CityService(
    private val repository: CityRepository,
    private val mapper: CityMapper
) {
    fun saveCity(data: City): City {
        val data = mapper.toEntity(data)
        val result = repository.save(data)
        return mapper.toDomain(result)
    }

    fun findAllCity() : List<City>{
        val allEntity = repository.findAll()
        return allEntity.stream().map {
            mapper.toDomain(it)
        }.toList()
    }
    fun findByIdCity(id : Long) : City? {
         val data = repository.findById(id).orElse(null)
        return mapper.toDomain(data)
    }
}