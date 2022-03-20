package web.config;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitialaizer {
    private UserService userService;
    private RoleService roleService;

    public DataInitialaizer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void Init() {
        Set<Role> allRoles = new HashSet<>();
        allRoles.add(new Role("ADMIN"));
        allRoles.add(new Role("USER"));
        roleService.createRoles(allRoles);
        User admin = new User("admin", "admin", 33, "admin@mail.ru", "admin");
        admin.setRoles("ADMIN, USER");
        userService.createUser(admin);
        User user = new User("user", "user", 22, "user@mail.ru", "user");
        user.setRoles("USER");
        userService.createUser(user);
        User user1 = new User("Misha", "Raia", 28, "misha_raia@mail.ru", "misha");
        user1.setRoles("USER");
        userService.createUser(user1);

    }
}
