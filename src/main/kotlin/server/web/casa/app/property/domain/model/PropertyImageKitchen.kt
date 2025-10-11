package server.web.casa.app.property.domain.model

data class PropertyImageKitchen(
    val propertyImageKitchenId : Long,
    val property : Property? = null,
    val name : String,
    val path : String
)
