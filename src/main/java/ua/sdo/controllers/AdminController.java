package ua.sdo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.sdo.model.accounts.Account;
import ua.sdo.model.payments.Payment;
import ua.sdo.model.users.User;
import ua.sdo.service.AccountService;
import ua.sdo.service.PaymentService;
import ua.sdo.service.UserService;

import java.util.List;
import java.util.Locale;

@Controller("/admin")
@Secured("ADMIN")
public class AdminController extends AbstractController {

    @ModelAttribute("payment")
    public Payment emptyPayment(){
        return new Payment();
    }

    @RequestMapping(value = "/")
    public String mainAdminPage(Model model, Locale locale){
        List<User> users = userService.getAll();
        model.addAttribute("usersList", users);
        return "admin";
    }

    @RequestMapping(value = "/info/{id}")
    public String infoAboutClientPage(@PathVariable("id") Integer id, Model model, Locale locale){
        List<Account> accounts = accountService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("accountLists", accounts);
        return "adinfo";
    }
}
