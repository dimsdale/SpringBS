package ua.sdo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.sdo.model.accounts.Account;
import ua.sdo.model.payments.Payment;
import ua.sdo.model.users.User;
import ua.sdo.service.AccountService;
import ua.sdo.service.PaymentService;
import ua.sdo.service.UserService;
import ua.sdo.validator.UserValidator;

import java.util.List;
import java.util.Locale;

@Controller
public class MainController {

    @Autowired
    protected UserService userService;

    @Autowired
    private UserValidator validator;

    @Autowired
    protected AccountService accountService;

    @Autowired
    protected PaymentService paymentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model, Locale locale){
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String mainPage(Model model, Locale locale){
        List<Account> accounts = accountService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("accountsList", accounts);
        return "main";
    }
    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public String login(Model model, Locale locale){
        return "login";
    }

    @RequestMapping(value = "/info/{id}")
    public String findPayments(@PathVariable("id") Integer id, Model model, Locale locale){
        List<Payment> payments = paymentService.findByAccountId(id);
        model.addAttribute("payments", payments);
        return "info";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model, Locale locale){
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult result)
    {

        validator.validate(user, result);
        if (result.hasErrors())
        {
            return "register";
        }
        userService.createUser(user);
        return "redirect:/index";
    }
}
