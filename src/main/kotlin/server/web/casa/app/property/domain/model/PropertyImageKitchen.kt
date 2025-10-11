package server.web.casa.app.property.domain.model

data class PropertyImageKitchen(
    val propertyImageKitchenId : Long,
    val property : Property,
    val name : String,
    val path : String
)
