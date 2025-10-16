package server.web.car.app.property.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.car.app.property.domain.model.PropertyImageRoom
import server.web.car.app.property.infrastructure.persistence.entity.PropertyImageRoomEntity

@Component
class PropertyImageRoomMapper{
    fun toDomain(p : PropertyImageRoomEntity): PropertyImageRoom {
        return PropertyImageRoom(
            propertyImageRoomId = p.propertyImageRoomId,
          //  property = propertyMapper.toDomain(p.property),
            name = p.name,
            path = p.path
        )
    }

    fun toEntity(p : PropertyImageRoom): PropertyImageRoomEntity {
        return PropertyImageRoomEntity(
            propertyImageRoomId = p.propertyImageRoomId,
         //   property = propertyMapper.toEntity(p.property),
            name = p.name,
            path = p.path
        )
    }
}