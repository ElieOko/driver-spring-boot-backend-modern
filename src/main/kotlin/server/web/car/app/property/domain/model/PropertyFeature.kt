package server.web.car.app.property.domain.model

data class PropertyFeature(
    val propertyFeatureId : Long,
    val property : List<Property?> = emptyList()
)
