package server.web.casa.app.property.infrastructure.persistence.mapper

import server.web.casa.app.property.domain.model.PropertyFeature
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyFeatureEntity

class PropertyFeatureMapper(
    private val propertyMapper: PropertyMapper
) {
    fun toDomain(p : PropertyFeatureEntity): PropertyFeature {
        return PropertyFeature(
            propertyFeatureId = p.propertyFeatureId,
            property = p.property.stream().map { propertyMapper.toDomain(it) }.toList()
        )
    }

    fun toEntity(p : PropertyFeature): PropertyFeatureEntity {
        return PropertyFeatureEntity(
            propertyFeatureId = p.propertyFeatureId,
            property = p.property.stream().map { propertyMapper.toEntity(it) }.toList()
        )
    }
}