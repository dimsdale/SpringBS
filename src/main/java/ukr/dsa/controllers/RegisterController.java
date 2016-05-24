package ukr.dsa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ukr.dsa.model.User;
import ukr.dsa.model.json.JSONConverter;
import ukr.dsa.services.impl.UserDetailsServiceImpl;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model){
        return "/register";
    }

    @ModelAttribute("user")
    public User loadEmptyUser(){
        return new User();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result)
    {
        if (result.hasErrors())
        {
            return "register";
        }
        JSONConverter.toJSON(user);
        userDetailsService.createUser(user);
        return "/index";
    }
}
