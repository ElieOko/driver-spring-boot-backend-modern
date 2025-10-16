package server.web.car.app.property.application.service

import org.springframework.stereotype.Service
import server.web.car.app.property.domain.model.PropertyFeature
import server.web.car.app.property.infrastructure.persistence.entity.PropertyFeatureEntity
import server.web.car.app.property.infrastructure.persistence.mapper.PropertyFeatureMapper
import server.web.car.app.property.infrastructure.persistence.repository.PropertyFeatureRepository

@Service
class PropertyFeatureService(
    private val repository: PropertyFeatureRepository,
    private val mapper : PropertyFeatureMapper
) {

    fun create(p : PropertyFeature): PropertyFeatureEntity {
        val data = mapper.toEntity(p)
        val result = repository.save(data)
        return result
    }
    fun getAll() : List<PropertyFeature> = repository.findAll().stream().map { mapper.toDomain(it) }.toList()

}