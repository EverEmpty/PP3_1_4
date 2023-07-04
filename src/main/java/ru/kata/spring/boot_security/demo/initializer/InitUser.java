package ru.kata.spring.boot_security.demo.initializer;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.entity.Role;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitUser{
    private final UserService userService;
    private final RoleService roleService;

    public InitUser(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @Transactional
    @PostConstruct
    public void createUser() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleService.saveRole(roleAdmin);
        roleService.saveRole(roleUser);
        Set<Role> set1 = new HashSet<>();
        set1.add(roleAdmin);
        Set<Role> set2 = new HashSet<>();
        set2.add(roleUser);
        Set<Role> set3 = new HashSet<>();
        set3.add(roleAdmin);
        set3.add(roleUser);
        User user1 = new User("admin", "admin", 30, "admin@mail.ru", "admin", set1);
        User user2 = new User("user", "user", 27, "user@mail.ru", "user", set2);
        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}