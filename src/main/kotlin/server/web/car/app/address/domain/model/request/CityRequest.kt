package server.web.car.app.address.domain.model.request

import jakarta.validation.constraints.NotNull

data class CityRequest(
    @NotNull
    val countryId : Long,
    @NotNull
    val name : String,
)