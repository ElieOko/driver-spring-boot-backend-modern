package server.web.car.app.property.domain.model

data class PropertyImageRoom(
    val propertyImageRoomId : Long,
    val property : Property? = null,
    val name : String,
    val path : String
)
