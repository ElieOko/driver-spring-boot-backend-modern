package server.web.car.app.property.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.car.app.property.domain.model.PropertyImageKitchen
import server.web.car.app.property.infrastructure.persistence.entity.PropertyImageKitchenEntity

@Component
class PropertyImageKitchenMapper{
    fun toDomain(p : PropertyImageKitchenEntity) : PropertyImageKitchen {
        return PropertyImageKitchen(
            propertyImageKitchenId = p.propertyImageKitchenId,
//            property = propertyMapper.toDomain(p.property),
            name = p.name,
            path = p.path
        )
    }

    fun toEntity(p : PropertyImageKitchen) : PropertyImageKitchenEntity {
        return PropertyImageKitchenEntity(
            propertyImageKitchenId = p.propertyImageKitchenId,
//            property = propertyMapper.toEntity(p.property),
            name = p.name,
            path = p.path
        )
    }
}