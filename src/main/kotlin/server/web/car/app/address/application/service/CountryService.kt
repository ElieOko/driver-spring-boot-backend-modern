package server.web.car.app.address.application.service

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import server.web.car.app.address.domain.model.Country
import server.web.car.app.address.infrastructure.persistence.mapper.CountryMapper
import server.web.car.app.address.infrastructure.persistence.repository.CountryRepository
import server.web.car.utils.Mode

@Service
@Profile(Mode.DEV)
class CountryService(
   private val repository: CountryRepository,
   private val mapper: CountryMapper
) {
    fun saveCountry(data: Country): Country {
        val data = mapper.toEntity(data)
        val result = repository.save(data)
        return mapper.toDomain(result)
    }
    fun findAllCountry() : List<Country>{
        val allEntity = repository.findAll()
        return allEntity.stream().map {
            mapper.toDomain(it)
        }.toList()
    }
}