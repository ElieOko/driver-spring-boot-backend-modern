package server.web.casa.app.property.domain.model

data class PropertyImageRoom(
    val propertyImageRoomId : Long,
    val property : Property?,
    val name : String,
    val path : String
)
