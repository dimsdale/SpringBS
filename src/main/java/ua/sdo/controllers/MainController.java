package ua.sdo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.sdo.model.CreditPayment;
import ua.sdo.model.accounts.Account;
import ua.sdo.model.accounts.DepositAccount;
import ua.sdo.model.users.Client;
import ua.sdo.model.users.User;

import java.util.Locale;

@Controller
public class MainController {
    @Autowired
    private MessageSource messageSource;

    @ModelAttribute("user")
    public User emptyUser(){
        return new Client();
    }

    @ModelAttribute("account")
    public Account emptyAccount(){
        return new DepositAccount();
    }

    @ModelAttribute("payment")
    public CreditPayment emptyPayment(){
        return new CreditPayment();
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model, Locale locale){
        System.out.println(locale.toString());
        return "index";
    }
}