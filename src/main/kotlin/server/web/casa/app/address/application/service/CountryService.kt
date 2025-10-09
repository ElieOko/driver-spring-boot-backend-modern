package server.web.casa.app.address.application.service

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import server.web.casa.app.address.domain.model.Country
import server.web.casa.app.address.infrastructure.persistence.mapper.CountryMapper
import server.web.casa.app.address.infrastructure.persistence.repository.CountryRepository
import server.web.casa.utils.Mode

@Service
@Profile(Mode.DEV)
class CountryService(
   private val repository: CountryRepository,
   private val mapper: CountryMapper
) {
    fun findAllCountry() : List<Country>{
        val allEntity = repository.findAll()
        return allEntity.stream().map {
            mapper.toDomain(it)
        }.toList()
    }
}