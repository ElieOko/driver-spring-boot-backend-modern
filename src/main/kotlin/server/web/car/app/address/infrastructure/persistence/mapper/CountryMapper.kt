package server.web.car.app.address.infrastructure.persistence.mapper

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import server.web.car.app.address.domain.model.Country
import server.web.car.app.address.infrastructure.persistence.entity.CountryEntity
import server.web.car.utils.Mode

@Component
@Profile(Mode.DEV)
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