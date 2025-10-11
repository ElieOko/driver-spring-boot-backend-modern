package server.web.casa.app.property.domain.model

data class PropertyImage(
    val propertyImageId : Long,
    val property : Property? = null,
    val name : String,
    val path : String
)
