package server.web.car.app.address.domain.model.request

import jakarta.validation.constraints.NotNull

data class CountryRequest(
    @NotNull
    val name : String
)
