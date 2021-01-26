
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import se.ifmo.ru.Lab4.entities.Role
import javax.persistence.*

@Entity
@Table(name = "t_user")
class User : UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    private var username: String? = null

    private var password: String? = null
    @Transient
    var passwordConfirm: String? = null
    @ManyToMany(fetch = FetchType.EAGER)
    var roles: Set<Role>? = null

    override fun getUsername(): String? {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    fun setUsername(username: String) {
        this.username = username
    }

    override fun getAuthorities(): Collection<GrantedAuthority>? {
        return roles
    }

    override fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }
}