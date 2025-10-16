package server.web.car.app.property.infrastructure.persistence.mapper

import org.springframework.stereotype.Component
import server.web.car.app.address.infrastructure.persistence.mapper.CityMapper
import server.web.car.app.property.domain.model.Property
import server.web.car.app.property.infrastructure.persistence.entity.PropertyEntity
import server.web.car.app.user.infrastructure.persistence.mapper.UserMapper

@Component
class PropertyMapper(
    private val cityMapper: CityMapper,
    private val userMapper: UserMapper,
    private val propertyImageLivingRoomMapper : PropertyImageLivingRoomMapper,
    private val propertyImageRoomMapper : PropertyImageRoomMapper,
//    private val propertyFavoriteMapper: PropertyFavoriteMapper,
    private val propertyImageMapper: PropertyImageMapper,
    private val propertyImageKitchenMapper: PropertyImageKitchenMapper,
    private val propertyTypeMapper: PropertyTypeMapper,
    private val propertyFeatureMapper: PropertyFeatureMapper
) {
    fun toDomain(p : PropertyEntity) : Property {
        return Property(
            propertyId = p.propertyId,
            title = p.title,
            description = p.description,
            price = p.price,
            surface = p.surface,
            rooms = p.rooms,
            bedrooms = p.bedrooms,
            kitchen = p.kitchen,
            livingRoom = p.livingRoom,
            bathroom = p.bathroom,
            floor = p.floor,
            address = p.address,
            city = cityMapper.toDomain(p.city) ,
            postalCode = p.postalCode,
            commune = TODO(),
            quartier = p.quartier,
            sold = p.sold,
            transactionType = p.transactionType,
            propertyType = propertyTypeMapper.toDomain(p.propertyType),
            user = userMapper.toDomain(p.user),
            latitude = p.latitude,
            longitude = p.longitude,
            isAvailable = p.isAvailable,
            features = p.features.stream().map { propertyFeatureMapper.toDomain(it) }.toList(),
//            favorites = p.favorites.stream().map { propertyFavoriteMapper.toDomain(it) }.toList(),
            propertyImage = p.propertyImage.stream().map { propertyImageMapper.toDomain(it) }.toList(),
            propertyImageRoom = p.propertyImageRoom.stream().map { propertyImageRoomMapper.toDomain(it) }.toList(),
            propertyImageLivingRoom = p.propertyImageLivingRoom.stream().map { propertyImageLivingRoomMapper.toDomain(it) }.toList(),
            propertyImageKitchen = p.propertyImageKitchen.stream().map { propertyImageKitchenMapper.toDomain(it) }.toList(),
            createdAt = p.createdAt,
            updatedAt = p.updatedAt
        )
    }

    fun toEntity(p : Property) : PropertyEntity {
        return PropertyEntity(
            propertyId = p.propertyId,
            title = p.title,
            description = p.description,
            price = p.price,
            surface = p.surface,
            rooms = p.rooms,
            bedrooms = p.bedrooms,
            kitchen = p.kitchen,
            livingRoom = p.livingRoom,
            bathroom = p.bathroom,
            floor = p.floor,
            address = p.address,
            city = cityMapper.toEntity(p.city) ,
            postalCode = p.postalCode,
            commune = TODO(),
            quartier = p.quartier,
            sold = p.sold,
            transactionType = p.transactionType,
            propertyType = propertyTypeMapper.toEntity(p.propertyType),
            user = userMapper.toEntity(p.user),
            latitude = p.latitude,
            longitude = p.longitude,
            isAvailable = p.isAvailable,
            features = p.features.stream().map { propertyFeatureMapper.toEntity(it) }.toList(),
//            favorites = p.favorites.stream().map { propertyFavoriteMapper.toEntity(it) }.toList(),
            propertyImage = p.propertyImage.stream().map { propertyImageMapper.toEntity(it) }.toList(),
            propertyImageRoom = p.propertyImageRoom.stream().map { propertyImageRoomMapper.toEntity(it) }.toList(),
            propertyImageLivingRoom = p.propertyImageLivingRoom.stream().map { propertyImageLivingRoomMapper.toEntity(it) }.toList(),
            propertyImageKitchen = p.propertyImageKitchen.stream().map { propertyImageKitchenMapper.toEntity(it) }.toList(),
            createdAt = p.createdAt,
            updatedAt = p.updatedAt
        )
    }
}