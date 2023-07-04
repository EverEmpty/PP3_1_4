package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select user from User user where user.name = :name")
    User findByName(@Param("name") String name);

    @Query("select user from User user where user.email = :email")
    User findByEmail(@Param("email") String email);
}
