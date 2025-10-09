package server.web.casa.app.address.infrastructure.persistence.mapper

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import server.web.casa.app.address.domain.model.District
import server.web.casa.app.address.infrastructure.persistence.entity.DistrictEntity
import server.web.casa.utils.Mode

@Component
@Profile(Mode.DEV)
class DistrictMapper(
    val cityMapper: CityMapper,
//    val communeMapper: CommuneMapper
) {
    fun toDomain(districtEntity: DistrictEntity): District{
        return District(
            districtId = districtEntity.districtId,
            city = cityMapper.toDomain(districtEntity.city),
            name = districtEntity.name,
//            commune = communeMapper.toDomain(districtEntity.commune)
        )
    }
    fun toEntity(district: District): DistrictEntity{
        return DistrictEntity(
            districtId = district.districtId,
            city = cityMapper.toEntity(district.city),
            name = district.name,
//            commune = communeMapper.toEntity(district.commune)
        )
    }
}