package server.web.car.app.address.infrastructure.persistence.mapper

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import server.web.car.app.address.domain.model.City
import server.web.car.app.address.infrastructure.persistence.entity.CityEntity
import server.web.car.utils.Mode

@Component
@Profile(Mode.DEV)
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