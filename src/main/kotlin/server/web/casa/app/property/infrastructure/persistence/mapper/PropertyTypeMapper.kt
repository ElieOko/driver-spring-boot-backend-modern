package server.web.casa.app.property.infrastructure.persistence.mapper

import server.web.casa.app.property.domain.model.PropertyType
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyTypeEntity

class PropertyTypeMapper(
    private val propertyMapper: PropertyMapper
) {
    fun toDomain(p : PropertyTypeEntity): PropertyType {
        return PropertyType(
            propertyTypeId = p.propertyTypeId,
            name = p.name,
            description = p.description,
            property = p.property.stream().map {  propertyMapper.toDomain(it) }.toList()
        )
    }

    fun toEntity(p : PropertyType): PropertyTypeEntity {
        return PropertyTypeEntity(
            propertyTypeId = p.propertyTypeId,
            name = p.name,
            description = p.description,
            property = p.property.stream().map {  propertyMapper.toEntity(it) }.toList()
        )
    }
}