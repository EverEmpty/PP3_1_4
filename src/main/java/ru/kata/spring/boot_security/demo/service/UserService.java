package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    List<User> userList();

    void saveUser(User user);

    void deleteUser(long id);

    void updateUser(User user);

    Optional<User> getUserById(long id);

    User getUserByName(String name);

    User getUserByEmail(String email);
}
