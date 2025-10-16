package server.web.car.app.property.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.car.app.property.domain.model.PropertyFavorite
import server.web.car.app.property.infrastructure.persistence.entity.PropertyFavoriteEntity

@Component
class PropertyFavoriteMapper{
    fun toDomain(p: PropertyFavoriteEntity) : PropertyFavorite {
        return PropertyFavorite(
            propertyFavoriteId = p.propertyFavoriteId,
            //property = p.property.stream().map { propertyMapper.toDomain(it) }.toList()
        )
    }

    fun toEntity(p : PropertyFavorite) : PropertyFavoriteEntity{
        return PropertyFavoriteEntity(
            propertyFavoriteId = p.propertyFavoriteId,
         //   property = p.property.stream().map { propertyMapper.toEntity(it) }.toList()
        )
    }
}