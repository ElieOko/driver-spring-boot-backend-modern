package server.web.car.app.property.domain.model

data class PropertyImageLivingRoom(
    val propertyImageLivingRoomId : Long,
    val property : Property? = null,
    val name : String,
    val path : String
)
