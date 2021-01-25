package se.ifmo.ru.Lab4.entities

import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
@Table(name="users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id :Long
)