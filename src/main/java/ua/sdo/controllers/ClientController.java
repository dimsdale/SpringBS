package ua.sdo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.sdo.model.accounts.Account;
import ua.sdo.model.accounts.DepositAccount;
import ua.sdo.model.payments.Payment;
import ua.sdo.model.users.Client;
import ua.sdo.model.users.User;
import ua.sdo.model.users.enums.UserType;
import ua.sdo.service.AccountService;
import ua.sdo.service.PaymentService;
import ua.sdo.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
public class ClientController extends AbstractController {

    @ModelAttribute("user")
    public User emptyUser(){
        return new Client();
    }

    @ModelAttribute("account")
    public Account emptyAccount(){
        return new DepositAccount();
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model, Locale locale){
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String mainPage(Model model, Locale locale){
        List<Account> accounts = accountService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("accountLists", accounts);
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
}