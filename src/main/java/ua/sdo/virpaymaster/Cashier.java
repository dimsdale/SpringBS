package ua.sdo.virpaymaster;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import ua.sdo.model.accounts.Account;
import ua.sdo.model.payments.Payment;
import ua.sdo.repository.AccountStatusRepository;
import ua.sdo.repository.AccountTypeRepository;
import ua.sdo.repository.TypePaymentRepository;
import ua.sdo.service.AccountService;
import ua.sdo.service.PaymentService;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class Cashier {

    public static final Logger log = Logger.getLogger(Cashier.class.getName());

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private TypePaymentRepository typePaymentRepository;

    @Autowired
    private AccountStatusRepository accountStatusRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    private Payment payment;
    @Scheduled(cron = "0 0 1 * 1 *")
    private void refreshAllAccounts(){
        log.info("Refreshing all accounts");
        List<Account> accounts = accountService.getAll();
        for (Account account : accounts){
            if (account.getAccountStatus().getId() != 2){
                payment = new Payment();
                payment.setAccount(account);
                payment.setSum(Math.ceil(account.getSum() * account.getPercentage()));
                payment.setDate_of_payment(new Date());
                if (account.getAccountType().getId() == 1){
                    payment.setType(typePaymentRepository.getOne(1));
                } else if (account.getAccountType().getId() == 2){
                    payment.setType(typePaymentRepository.getOne(2));
                }
                paymentService.addPay(payment);
                accountService.updateSumAccount(account.getSum() + payment.getSum(), account.getId());
                payment = null;
                continue;
            }
        }
    }

    public void submitPaymentToAccount(Account account, Payment payment){
        log.info("Refresh current account");
        account.setSum(Math.floor(account.getSum() - payment.getSum()));
        if (account.getSum() == 0){
            accountService.closeAccount(account.getId());
            return;
        }
        if (account.getSum() < 0){
            double leftover = 0 - account.getSum();
            accountService.closeAccount(account.getId());
            List<Account> accounts = accountService.findByIdClient(account.getUser().getId());
            boolean findDeposit = false;
            for (Account otherAccountOfClient : accounts){
                if (otherAccountOfClient.getAccountStatus().getId() == 1 && otherAccountOfClient.getAccountType().getId() == 2){
                    accountService.updateSumAccount((otherAccountOfClient.getSum() + leftover), otherAccountOfClient.getId());
                    findDeposit = true;
                    break;
                }
            }
            if (!findDeposit){
                Account newAccountClient = new Account();
                newAccountClient.setSum(leftover);
                newAccountClient.setDate_of_open(new Date());
                newAccountClient.setAccountStatus(accountStatusRepository.getOne(1));
                newAccountClient.setPercentage(5);
                newAccountClient.setUser(account.getUser());
                newAccountClient.setAccountType(accountTypeRepository.getOne(2));
                newAccountClient.setTerm_of_credit(6);
                accountService.createAccount(newAccountClient);
            }
            return;
        }
        if (account.getSum() > 0){
            accountService.updateSumAccount(account.getSum(), account.getId());
            return;
        }
    }
}
