package server.web.casa.app.property.application.service

import org.springframework.stereotype.Service
import server.web.casa.app.property.domain.model.PropertyImageKitchen
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyImageKitchenEntity
import server.web.casa.app.property.infrastructure.persistence.mapper.PropertyImageKitchenMapper
import server.web.casa.app.property.infrastructure.persistence.repository.PropertyImageKitchenRepository

@Service
class PropertyImageKitchenService(
    private val repository: PropertyImageKitchenRepository,
    private val mapper : PropertyImageKitchenMapper
) {
    fun create(p : PropertyImageKitchen): PropertyImageKitchenEntity {
        val data = mapper.toEntity(p)
        val result = repository.save(data)
        return result
    }
    fun getAll() : List<PropertyImageKitchen> = repository.findAll().stream().map { mapper.toDomain(it) }.toList()

}