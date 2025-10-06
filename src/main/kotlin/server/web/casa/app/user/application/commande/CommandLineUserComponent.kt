package server.web.casa.app.user.application.commande

import org.hibernate.exception.ConstraintViolationException
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import server.web.casa.app.user.infrastructure.persistence.TypeAccountEntity
import server.web.casa.app.user.infrastructure.persistence.repository.TypeAccountRepository

@Component
@Order(0)
class CommandLineUserComponent(
    val typeAccountRepository: TypeAccountRepository
) : CommandLineRunner {
    private val log = LoggerFactory.getLogger(this::class.java)
    override fun run(vararg args: String) {
        log.info("commande executor **User")
        log.info(this::class.simpleName)
        try {
            //createTypeAccount()
            getAllTypeAccount()
        }
        catch (e : ConstraintViolationException){
            log.info(e.message)
        }

    }
    fun createTypeAccount(){
        val store: List<TypeAccountEntity?> = typeAccountRepository.saveAll<TypeAccountEntity>(
            listOf(
                TypeAccountEntity(name= "autonome"),
                TypeAccountEntity(name= "commissionnaire"),
                TypeAccountEntity(name = "bailleur"),
                TypeAccountEntity(name = "locataire"),
            )
        )
        log.info("Enregistrement réussi avec succès")
        log.info("@".repeat(12))
        store.forEach { typeAccountRepository->
            log.info("${typeAccountRepository?.name} ${typeAccountRepository?.typeAccountId}")
//            log.info()
        }
//        log.info("Enregistrement réussi avec succès")
    }

    fun getAllTypeAccount(){
        typeAccountRepository.findAll().forEach { accountEntity ->
            log.info("${accountEntity.name} | ${accountEntity.typeAccountId}")
        }
    }
}