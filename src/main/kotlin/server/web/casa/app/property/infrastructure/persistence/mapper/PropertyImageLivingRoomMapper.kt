package server.web.casa.app.property.infrastructure.persistence.mapper

import server.web.casa.app.property.domain.model.PropertyImageLivingRoom
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyImageLivingRoomEntity

class PropertyImageLivingRoomMapper(
    private val propertyMapper: PropertyMapper
) {
    fun toDomain(p : PropertyImageLivingRoomEntity): PropertyImageLivingRoom {
        return PropertyImageLivingRoom(
            propertyImageLivingRoomId = p.propertyImageLivingRoomId,
            property = propertyMapper.toDomain(p.property),
            name = p.name,
            path = p.path
        )
    }

    fun toEntity(p : PropertyImageLivingRoom): PropertyImageLivingRoomEntity {
        return PropertyImageLivingRoomEntity(
            propertyImageLivingRoomId = p.propertyImageLivingRoomId,
            property = propertyMapper.toEntity(p.property),
            name = p.name,
            path = p.path
        )
    }
}