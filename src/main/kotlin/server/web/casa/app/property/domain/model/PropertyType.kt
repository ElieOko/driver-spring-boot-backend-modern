package server.web.casa.app.property.domain.model

data class PropertyType(
    val propertyTypeId : Long,
    val name : String,
    val description : String? = "",
    val property : List<Property>
)
