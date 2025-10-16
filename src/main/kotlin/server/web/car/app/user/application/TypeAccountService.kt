package server.web.car.app.user.application

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import server.web.car.app.user.domain.model.TypeAccount
import server.web.car.app.user.infrastructure.persistence.entity.TypeAccountEntity
import server.web.car.app.user.infrastructure.persistence.mapper.TypeAccountMapper
import server.web.car.app.user.infrastructure.persistence.repository.TypeAccountRepository
import server.web.car.utils.Mode

@Service
@Profile(Mode.DEV)
class TypeAccountService(
  private val repository: TypeAccountRepository,
  private val mapper: TypeAccountMapper
) {
    fun saveAccount(data: TypeAccount): TypeAccount {
        val data = mapper.toEntity(data)
        val result = repository.save(data)
        return mapper.toDomain(result)
    }
    fun getAll() : List<TypeAccount> {
        val data: List<TypeAccountEntity?> = repository.findAll()
        return data.stream().map {
            mapper.toDomain(TypeAccountEntity(it!!.typeAccountId,it.name))
        }.toList()
    }

    fun findByIdTypeAccount(id : Long) : TypeAccount? {
        val data = repository.findById(id).orElse(null)
        return mapper.toDomain(data)
    }
}