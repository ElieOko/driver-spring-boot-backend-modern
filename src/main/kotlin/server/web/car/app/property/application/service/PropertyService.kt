package server.web.car.app.property.application.service

import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import server.web.car.app.property.domain.model.Property
import server.web.car.app.property.infrastructure.persistence.entity.PropertyEntity
import server.web.car.app.property.infrastructure.persistence.mapper.PropertyMapper
import server.web.car.app.property.infrastructure.persistence.repository.PropertyRepository

@Service
class PropertyService(
    private val repository: PropertyRepository,
    private val mapper : PropertyMapper
) {

    fun create(p : Property): PropertyEntity {
        val data = mapper.toEntity(p)
        val result = repository.save(data)
        return result
    }
    fun getAll() : List<Property> = repository.findAll().stream().map { mapper.toDomain(it) }.toList()

    fun findByIdProperty(id : Long) : Property? {
        val data = repository.findById(id).orElseThrow { ->
            EntityNotFoundException("Aucune proprièté avec cet identifiant $id")
        }
        return mapper.toDomain(data)
    }
}