package ua.sdo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import ua.sdo.service.AccountService;
import ua.sdo.service.PaymentService;
import ua.sdo.service.UserService;

public abstract class AbstractController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected AccountService accountService;

    @Autowired
    protected PaymentService paymentService;
}
