package ua.sdo.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.sdo.model.users.User;
import ua.sdo.service.UserService;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "label.NotNull");
        if (user.getLogin().length() < 4 || user.getLogin().length() > 50){
            errors.rejectValue("login", "SizeLogin");
        }
        if (userService.findByName(user.getLogin()) != null){
            errors.rejectValue("login", "label.NotUnique");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "label.NotNull");

        if (user.getPassword().length() < 5){
            errors.rejectValue("password", "SizePassword");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("confirmPassword", "DifferentFields");
        }
    }
}
