package server.web.casa.app.user.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import server.web.casa.app.user.infrastructure.persistence.entity.UserEntity

interface UserRepository : JpaRepository<UserEntity, Long> {

//    @Query("select")
//@Query("""
//       SELECT r from users r
//            WHERE (:username IS NULL OR r.username = :username)
//            OR (:username IS NULL OR r.email = :username)
//            OR (:username IS NULL OR r.phone = :username)
//       """)
fun findByUsername(@Param("username") username: String): UserEntity?

}