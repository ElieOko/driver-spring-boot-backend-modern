package server.web.casa.app.address.domain.model.request

import jakarta.validation.constraints.NotNull

data class DistrictRequest(
    @NotNull
    val name : String,
    @NotNull
    val cityId : Long
)