package se.ifmo.ru.Lab4.entities

import se.ifmo.ru.Lab4.entities.User
import javax.persistence.ManyToMany
import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "t_role")
class Role : GrantedAuthority {
    @Id
    var id: Long? = null
    var name: String? = null
    @Transient
    @ManyToMany(mappedBy = "roles")
    var users: Set<User>? = null

    constructor() {}

    constructor(id: Long?) {
        this.id = id
    }

    constructor(id: Long?, name: String) {
        this.id = id
        this.name = name
    }

    override fun getAuthority(): String? {
        return name
    }
}
