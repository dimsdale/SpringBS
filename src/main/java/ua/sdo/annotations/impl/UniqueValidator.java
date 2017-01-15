package ua.sdo.annotations.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.sdo.annotations.Unique;
import ua.sdo.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueValidator implements ConstraintValidator<Unique, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(Unique unique) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null)
        {
            return true;
        }
        boolean loginExists = userRepository.countUserByLogin(s) > 0;
        System.out.println(loginExists);
        if (!loginExists)
        {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("User " + s + "already exists!")
                    .addConstraintViolation();
        }
        return !loginExists;
    }
}
