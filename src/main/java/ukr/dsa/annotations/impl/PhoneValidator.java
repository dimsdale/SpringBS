package ukr.dsa.annotations.impl;

import ukr.dsa.annotations.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PhoneValidator implements ConstraintValidator<Phone, String > {
    @Override
    public void initialize(Phone phone) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || !s.contains("+380"))
        {
            return false;
        }
        return s.matches("[0-9+()]*");
    }
}
