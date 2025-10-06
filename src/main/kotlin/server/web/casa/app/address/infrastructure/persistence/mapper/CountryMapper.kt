package server.web.casa.app.address.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.casa.app.address.domain.model.Country
import server.web.casa.app.address.infrastructure.persistence.entity.CountryEntity

@Component
class CountryMapper(
//    val cityMapper: CityMapper
) {
    fun toDomain(countryEntity: CountryEntity): Country{
        return Country(
            countryId = countryEntity.countryId,
//            city = cityMapper.toDomain(countryEntity.city),
            name = countryEntity.name
        )
    }
    fun toEntity(country: Country) : CountryEntity {
        return CountryEntity(
            countryId = country.countryId,
//            city = cityMapper.toEntity(country.city),
            name = country.name
        )
    }
}