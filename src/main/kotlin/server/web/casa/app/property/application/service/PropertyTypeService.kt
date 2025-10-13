package server.web.casa.app.property.application.service

import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import server.web.casa.app.property.domain.model.PropertyType
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyTypeEntity
import server.web.casa.app.property.infrastructure.persistence.mapper.PropertyTypeMapper
import server.web.casa.app.property.infrastructure.persistence.repository.PropertyTypeRepository

@Service
class PropertyTypeService(
    private val repository: PropertyTypeRepository,
    private val mapper : PropertyTypeMapper
) {
    fun create(p : PropertyType): PropertyTypeEntity {
        val data = mapper.toEntity(p)
        val result = repository.save(data)
        return result
    }
    fun getAll() : List<PropertyType> = repository.findAll().stream().map { mapper.toDomain(it) }.toList()

    fun findByIdPropertyType(id : Long) : PropertyType? {
        val data = repository.findById(id).orElseThrow { ->
            EntityNotFoundException("Aucun type de proprièté avec cet identifiant $id")
        }
        return mapper.toDomain(data)
    }



}