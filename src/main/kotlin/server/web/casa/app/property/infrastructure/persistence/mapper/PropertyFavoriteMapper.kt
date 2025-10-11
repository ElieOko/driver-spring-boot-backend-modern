package server.web.casa.app.property.infrastructure.persistence.mapper

import server.web.casa.app.property.domain.model.PropertyFavorite
import server.web.casa.app.property.infrastructure.persistence.entity.PropertyFavoriteEntity

class PropertyFavoriteMapper(
    private val propertyMapper: PropertyMapper
) {
    fun toDomain(p: PropertyFavoriteEntity) : PropertyFavorite {
        return PropertyFavorite(
            propertyFavoriteId = p.propertyFavoriteId,
            property = p.property.stream().map { propertyMapper.toDomain(it) }.toList()
        )
    }

    fun toEntity(p : PropertyFavorite) : PropertyFavoriteEntity{
        return PropertyFavoriteEntity(
            propertyFavoriteId = p.propertyFavoriteId,
            property = p.property.stream().map { propertyMapper.toEntity(it) }.toList()
        )
    }
}