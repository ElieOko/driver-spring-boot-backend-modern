package server.web.car.app.property.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.car.app.property.domain.model.PropertyImage
import server.web.car.app.property.infrastructure.persistence.entity.PropertyImageEntity

@Component
class PropertyImageMapper{
    fun toDomain(p : PropertyImageEntity) : PropertyImage {
        return PropertyImage(
            propertyImageId = p.propertyImageId,
//            property = propertyMapper.toDomain(p.property),
            name = p.name,
            path = p.path
        )
    }

    fun toEntity(p : PropertyImage): PropertyImageEntity {
        return PropertyImageEntity(
            propertyImageId = p.propertyImageId,
//            property = propertyMapper.toEntity(p.property),
            name = p.name,
            path = p.path
        )
    }
}