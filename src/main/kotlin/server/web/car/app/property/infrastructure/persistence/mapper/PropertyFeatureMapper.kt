package server.web.car.app.property.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.car.app.property.domain.model.PropertyFeature
import server.web.car.app.property.infrastructure.persistence.entity.PropertyFeatureEntity

@Component
class PropertyFeatureMapper{
    fun toDomain(p : PropertyFeatureEntity): PropertyFeature {
        return PropertyFeature(
            propertyFeatureId = p.propertyFeatureId,
           // property = p.property.stream().map { propertyMapper.toDomain(it) }.toList()
        )
    }

    fun toEntity(p : PropertyFeature): PropertyFeatureEntity {
        return PropertyFeatureEntity(
            propertyFeatureId = p.propertyFeatureId,
          //  property = p.property.stream().map { propertyMapper.toEntity(it) }.toList()
        )
    }
}