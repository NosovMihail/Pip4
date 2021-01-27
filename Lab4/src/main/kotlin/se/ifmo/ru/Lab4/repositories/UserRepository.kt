package se.ifmo.ru.Lab4.repositories

import java.util.Optional
import org.springframework.data.repository.query.Param
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import se.ifmo.ru.Lab4.entities.User
import javax.transaction.Transactional

interface UserRepository: CrudRepository<User, Long> {


    fun findByUsername(@Param("username") username: String): Optional<User>

    @Query(value = "select u.password from User u where u.username=?1")
    fun findPass(name:String):String
}