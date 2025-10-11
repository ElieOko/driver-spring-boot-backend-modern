package server.web.casa.app.property.application.service

import org.springframework.stereotype.Service
import server.web.casa.app.property.domain.model.PropertyImageLivingRoom
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyImageLivingRoomEntity
import server.web.casa.app.property.infrastructure.persistence.mapper.PropertyImageLivingRoomMapper
import server.web.casa.app.property.infrastructure.persistence.repository.PropertyImageLivingRoomRepository

@Service
class PropertyImageLivingRoomService(
    private val repository: PropertyImageLivingRoomRepository,
    private val mapper : PropertyImageLivingRoomMapper
) {
    fun create(p : PropertyImageLivingRoom): PropertyImageLivingRoomEntity {
        val data = mapper.toEntity(p)
        val result = repository.save(data)
        return result
    }
    fun getAll() : List<PropertyImageLivingRoom> = repository.findAll().stream().map { mapper.toDomain(it) }.toList()
}