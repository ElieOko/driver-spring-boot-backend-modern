package server.web.casa.app.property.application.service

import org.springframework.stereotype.Service
import server.web.casa.app.property.domain.model.PropertyImageRoom
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyImageRoomEntity
import server.web.casa.app.property.infrastructure.persistence.mapper.PropertyImageRoomMapper
import server.web.casa.app.property.infrastructure.persistence.repository.PropertyImageRoomRepository

@Service
class PropertyImageRoomService(
    private val repository: PropertyImageRoomRepository,
    private val mapper : PropertyImageRoomMapper
) {
    fun create(p : PropertyImageRoom): PropertyImageRoomEntity {
        val data = mapper.toEntity(p)
        val result = repository.save(data)
        return result
    }
    fun getAll() : List<PropertyImageRoom> = repository.findAll().stream().map { mapper.toDomain(it) }.toList()
}