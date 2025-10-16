package server.web.car.app.address.domain.model.request

import jakarta.validation.constraints.NotNull

data class CommuneRequest(
    @NotNull
    val name : String,
    @NotNull
    val districtId : Long
)
