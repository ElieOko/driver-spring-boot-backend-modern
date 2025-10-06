package server.web.casa.app.address.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.casa.app.address.domain.model.City
import server.web.casa.app.address.infrastructure.persistence.entity.CityEntity

@Component
class CityMapper(
//    val userMapper: UserMapper,
    val countryMapper: CountryMapper,
//    val districtMapper: DistrictMapper
) {
    fun toDomain(cityEntity: CityEntity) : City{
        return City(
            cityId =cityEntity.cityId,
            country = countryMapper.toDomain(cityEntity.country),
            name = cityEntity.name,
//            user = userMapper.toDomain(cityEntity.user),
//            district = districtMapper.toDomain(cityEntity.district)
        )
    }
    fun toEntity(city: City?) : CityEntity{
        return CityEntity(
            cityId = city!!.cityId,
            country = countryMapper.toEntity(city.country),
            name = city.name,
           // user = userMapper.toEntity(city.user),
           // district = districtMapper.toEntity(city.district)
        )
    }
}