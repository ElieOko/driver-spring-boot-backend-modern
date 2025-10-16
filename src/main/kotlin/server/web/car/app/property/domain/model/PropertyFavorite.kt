package server.web.car.app.property.domain.model

data class PropertyFavorite(
    val propertyFavoriteId : Long,
    val property : List<Property?> = emptyList()
)
