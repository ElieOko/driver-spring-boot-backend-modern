package server.web.car.app.property.application.service

import org.springframework.stereotype.Service
import server.web.car.app.property.domain.model.PropertyImage
import server.web.car.app.property.infrastructure.persistence.entity.PropertyImageEntity
import server.web.car.app.property.infrastructure.persistence.mapper.PropertyImageMapper
import server.web.car.app.property.infrastructure.persistence.repository.PropertyImageRepository

@Service
class PropertyImageService(
    private val repository: PropertyImageRepository,
    private val mapper : PropertyImageMapper
) {
    fun create(p : PropertyImage): PropertyImageEntity {
        val data = mapper.toEntity(p)
        val result = repository.save(data)
        return result
    }
    fun getAll() : List<PropertyImage> = repository.findAll().stream().map { mapper.toDomain(it) }.toList()

}