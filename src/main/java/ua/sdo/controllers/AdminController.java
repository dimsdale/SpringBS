package ua.sdo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.sdo.model.accounts.Account;
import ua.sdo.model.payments.Payment;
import ua.sdo.model.users.User;
import ua.sdo.repository.AccountStatusRepository;
import ua.sdo.repository.AccountTypeRepository;
import ua.sdo.repository.PaymentRepository;
import ua.sdo.repository.TypePaymentRepository;
import ua.sdo.service.AccountService;
import ua.sdo.service.PaymentService;
import ua.sdo.service.UserService;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller()
@RequestMapping(value = "/admin", method = RequestMethod.GET)
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AccountStatusRepository accountStatusRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private TypePaymentRepository typePaymentRepository;

    @ModelAttribute("account")
    public Account emptyAccount(){
        return new Account();
    }


    @RequestMapping()
    public String mainAdminPage(Model model, Locale locale){
        List<User> users = userService.getAllClients();
        model.addAttribute("usersList", users);
        return "admin";
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public String infoAboutClientPage(@PathVariable("id") Integer id, Model model, Locale locale){
        List<Account> accounts = accountService.findByIdClient(id);
        model.addAttribute("accountLists", accounts);
        return "adinfo";
    }

    @RequestMapping(value = "/pay/{id}", method = RequestMethod.GET)
    public String newPaymentForAccount(@PathVariable("id") Integer id, Model model, Locale locale, HttpSession httpSession){
        httpSession.setAttribute("idAcc", id);
        model.addAttribute("payment", new Payment());
        model.addAttribute("typesPayment", typePaymentRepository.findAll());
        return "pay";
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String submitPayment(@ModelAttribute("payment") Payment payment, Model model, Locale locale, HttpSession httpSession){
       int accId = (Integer) httpSession.getAttribute("idAcc");
        Account account = accountService.getById(accId);
        payment.setAccount(account);
        payment.setDate_of_payment(new Date());
        paymentRepository.save(payment);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/payments/{id}", method = RequestMethod.GET)
    public String allPaymentsOfAccount(@PathVariable("id") Integer id, Model model, Locale locale){
        model.addAttribute("payments", paymentService.findByAccountId(id));
        return "payments";
    }

}
