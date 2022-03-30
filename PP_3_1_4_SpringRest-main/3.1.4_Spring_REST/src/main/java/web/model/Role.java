package web.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Set;

@Entity
@Transactional
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    private String roleName;

    @Transient
    @ManyToMany(mappedBy = "roles")

    @JoinTable (
            name = "users_roles",
            joinColumns = {
                    @JoinColumn(name = "role_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id")})
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }


    public void setUsers(Set<User> users){
        this.users=users;
    }
    public Role() {}

    public Role(String roleName) {
        if (roleName.contains("ADMIN")) {
            this.id = 1L;
        } else if (roleName.contains("USER")) {
            this.id = 2L;
        }
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role) {
        this.roleName = role;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }

}
