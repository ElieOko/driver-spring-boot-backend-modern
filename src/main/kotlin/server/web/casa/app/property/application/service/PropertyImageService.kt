package server.web.casa.app.property.application.service

import org.springframework.stereotype.Service
import server.web.casa.app.property.domain.model.Property
import server.web.casa.app.property.domain.model.PropertyImage
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyEntity
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyImageEntity
import server.web.casa.app.property.infrastructure.persistence.mapper.PropertyImageMapper
import server.web.casa.app.property.infrastructure.persistence.repository.PropertyImageRepository

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