package ua.sdo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.sdo.model.accounts.Account;
import ua.sdo.model.accounts.DepositAccount;
import ua.sdo.model.payments.Payment;
import ua.sdo.model.users.User;
import ua.sdo.service.AccountService;
import ua.sdo.service.PaymentService;
import ua.sdo.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller()
@RequestMapping(value = "/admin", method = RequestMethod.GET)
public class AdminController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected AccountService accountService;

    @Autowired
    protected PaymentService paymentService;

    @ModelAttribute("payment")
    public Payment emptyPayment(){
        return new Payment();
    }

    @ModelAttribute("account")
    public Account emptyAccount(){
        return new DepositAccount();
    }


    @RequestMapping()
    public String mainAdminPage(Model model, Locale locale){
        List<User> users = userService.getAllClients();
        model.addAttribute("usersList", users);
        return "admin";
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public String infoAboutClientPage(@PathVariable("id") Integer id, Model model, Locale locale){
        List<Account> accounts = accountService.findById(id);
        model.addAttribute("accountLists", accounts);
        return "adinfo";
    }

    @RequestMapping(value = "/pay/{id}", method = RequestMethod.POST)
    public String newPaymentForAccount(@PathVariable("id") Integer id, Model model, Locale locale, HttpSession httpSession){
        httpSession.setAttribute("idAcc", id);
        return "pay";
    }

    @RequestMapping(value = "/payAdd", method = RequestMethod.POST)
    public String submitPayment(@Valid Payment payment, Model model, Locale locale, HttpSession httpSession){
       int accId = (Integer) httpSession.getAttribute("idAcc");
        paymentService.createPayment(accId ,payment);
        return "admin";
    }

    @RequestMapping(value = "/payments/{id}", method = RequestMethod.GET)
    public String allPaymentsOfAccount(@PathVariable("id") Integer id, Model model, Locale locale){
        model.addAttribute("payments", paymentService.findByAccountId(id));
        return "payments";
    }

}
