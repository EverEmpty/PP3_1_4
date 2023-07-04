package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> roleList();

    void saveRole(Role role);

    Optional<Role> getRoleById(long id);
}
