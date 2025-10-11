package server.web.casa.app.property.domain.model

data class PropertyFavorite(
    val propertyFavoriteId : Long,
    val property : List<Property>
)
