package server.web.casa.app.property.infrastructure.persistence.mapper

import server.web.casa.app.property.domain.model.PropertyImage
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyImageEntity

class PropertyImageMapper(
    private val propertyMapper: PropertyMapper
) {
    fun toDomain(p : PropertyImageEntity) : PropertyImage {
        return PropertyImage(
            propertyImageId = p.propertyImageId,
            property = propertyMapper.toDomain(p.property),
            name = p.name,
            path = p.path
        )
    }

    fun toEntity(p : PropertyImage): PropertyImageEntity {
        return PropertyImageEntity(
            propertyImageId = p.propertyImageId,
            property = propertyMapper.toEntity(p.property),
            name = p.name,
            path = p.path
        )
    }
}