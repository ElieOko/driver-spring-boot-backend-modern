package server.web.casa.app.address.application.command

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import server.web.casa.app.address.infrastructure.persistence.entity.CityEntity
import server.web.casa.app.address.infrastructure.persistence.entity.CountryEntity
import server.web.casa.app.address.infrastructure.persistence.repository.CityRepository
import server.web.casa.app.address.infrastructure.persistence.repository.CountryRepository
import kotlin.jvm.optionals.toList

@Component
@Order(1)
class CommandLineAddressComponent(
   private val cityRepository: CityRepository,
   private val countryRepository: CountryRepository
) : CommandLineRunner {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun run(vararg args: String) {
        log.info("***********************")
        createCountry()
    }

    fun createCity(){
        val country = countryRepository.findById(1).toList()
        cityRepository.save(CityEntity(
            cityId = 0,
            country = country[0],
            name ="Kinshasa",
        ))
        log.info("save city")
    }
    fun createCountry(){
        countryRepository.save(
            CountryEntity(
                countryId = 0,
                name = "République démocratique du Congo"
            )
        )
        log.info("save country")
    }
}