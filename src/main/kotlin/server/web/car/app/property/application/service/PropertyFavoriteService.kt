package server.web.car.app.property.application.service

import org.springframework.stereotype.Service
import server.web.car.app.property.domain.model.PropertyFavorite
import server.web.car.app.property.infrastructure.persistence.entity.PropertyFavoriteEntity
import server.web.car.app.property.infrastructure.persistence.mapper.PropertyFavoriteMapper
import server.web.car.app.property.infrastructure.persistence.repository.PropertyFavoriteRepository

@Service
class PropertyFavoriteService(
    private val repository: PropertyFavoriteRepository,
    private val mapper : PropertyFavoriteMapper
) {

    fun create(p : PropertyFavorite): PropertyFavoriteEntity {
        val data = mapper.toEntity(p)
        val result = repository.save(data)
        return result
    }
    fun getAll() : List<PropertyFavorite> = repository.findAll().stream().map { mapper.toDomain(it) }.toList()

    fun remove(id : Long){
        val data = repository.findById(id).orElse(null)
        if (data != null){
            repository.delete(data)
        }
    }


}