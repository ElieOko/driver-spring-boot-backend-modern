package server.web.casa.app.address.application.service

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import server.web.casa.app.address.domain.model.City
import server.web.casa.app.address.infrastructure.persistence.entity.CityEntity
import server.web.casa.app.address.infrastructure.persistence.mapper.CityMapper
import server.web.casa.app.address.infrastructure.persistence.repository.CityRepository
import server.web.casa.utils.Mode
import java.util.Optional
import kotlin.streams.toList

@Service
@Profile(Mode.DEV)
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
    fun findByIdCity(id : Long) : City? {
         val data = repository.findById(id).orElse(null)
        return mapper.toDomain(data)
    }
}