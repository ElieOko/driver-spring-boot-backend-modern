package server.web.casa.app.property.domain.model

data class PropertyFeature(
    val propertyFeatureId : Long,
    val property : List<Property?> = emptyList()
)
