package ru.kata.spring.boot_security.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

@Component
public class UserValidator implements Validator {

    private final UserServiceImpl userServiceImpl;

    public UserValidator(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        var user = (User) target;
        if (userServiceImpl.getUserByEmail(user.getEmail()) != null) {
         errors.rejectValue("email", "", "This email is already taken");
        }

    }
}
