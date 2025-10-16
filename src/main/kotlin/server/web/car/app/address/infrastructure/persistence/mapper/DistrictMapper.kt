package server.web.car.app.address.infrastructure.persistence.mapper

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import server.web.car.app.address.domain.model.District
import server.web.car.app.address.infrastructure.persistence.entity.DistrictEntity
import server.web.car.utils.Mode

@Component
@Profile(Mode.DEV)
class DistrictMapper(
    val cityMapper: CityMapper
) {
    fun toDomain(districtEntity: DistrictEntity?): District?{
        return if (districtEntity != null) District(
            districtId = districtEntity.districtId,
            city = cityMapper.toDomain(districtEntity.city),
            name = districtEntity.name
        ) else null
    }
    fun toEntity(district: District?): DistrictEntity?{
        return if (district != null) DistrictEntity(
            districtId = district.districtId,
            city = cityMapper.toEntity(district.city),
            name = district.name
        ) else null
    }
}