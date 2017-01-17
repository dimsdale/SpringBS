package ua.sdo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.sdo.model.users.User;
import ua.sdo.model.users.enums.UserType;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class RegisterController extends AbstractController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model, Locale locale){
        return "register";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result)
    {
        if (result.hasErrors())
        {
            return "register";
        }
        user.setUserType(UserType.CLIENT);
        userService.createUser(user);
        return "index";
    }
}
