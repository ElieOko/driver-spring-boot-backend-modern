package server.web.casa.app.address.application.service

import org.springframework.stereotype.Service
import server.web.casa.app.address.domain.model.District
import server.web.casa.app.address.infrastructure.persistence.entity.DistrictEntity
import server.web.casa.app.address.infrastructure.persistence.mapper.DistrictMapper
import server.web.casa.app.address.infrastructure.persistence.repository.DistrictRepository

@Service
class DistrictService(
    private val repository: DistrictRepository,
    private val mapper : DistrictMapper
) {
    fun saveDistrict(data: District): District? {
        val entity: DistrictEntity? = mapper.toEntity(data)
        if ( entity != null){
            val result = repository.save(entity)
            return mapper.toDomain(result)
        }
        return entity
    }

    fun findAllDistrict() : List<District?>{
        val allEntity = repository.findAll()
        return allEntity.stream().map {
            mapper.toDomain(it)
        }.toList()
    }

    fun findByIdDistrict(id : Long) : District? {
        val data = repository.findById(id).orElse(null)
        return mapper.toDomain(data)
    }
}