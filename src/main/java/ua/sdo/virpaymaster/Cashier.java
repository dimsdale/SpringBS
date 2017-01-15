package ua.sdo.virpaymaster;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import ua.sdo.model.CreditPayment;
import ua.sdo.model.accounts.Account;
import ua.sdo.model.accounts.CreditAccount;
import ua.sdo.model.accounts.DepositAccount;
import ua.sdo.model.accounts.enums.AccountStatus;
import ua.sdo.repository.AccountRepository;

import java.util.List;
@Repository
public class Cashier {

    @Autowired
    private AccountRepository accountRepository;


    @Scheduled(fixedDelay = 86400000)
    private void refreshAllAccounts(){
        List<Account> accounts = accountRepository.findAll();
        if (accounts != null){
            for (Account account: accounts){
                if (account instanceof DepositAccount && account.getAccountStatus() == AccountStatus.OPEN){
                    double newBalance = account.getSum() + (account.getSum() * account.getPercentage() / 100);
                    accountRepository.updateSumAccount(newBalance, account.getId());
                    continue;
                } else if (account instanceof CreditAccount && account.getAccountStatus() == AccountStatus.OPEN){
                    double newBalance = account.getSum() + (account.getSum() * account.getPercentage() / 100);
                    accountRepository.updateSumAccount(newBalance, account.getId());
                    continue;
                }
            }
        }
    }

    private void refreshCreditAccount(CreditAccount creditAccount, CreditPayment creditPayment){
        double leftover = creditAccount.getSum() - creditPayment.getSum();
        if (leftover > 0 && creditPayment.getSum() != 0){
            creditAccount.setSum(creditAccount.getSum() - creditPayment.getSum());
            accountRepository.updateSumAccount(creditPayment.getSum(), creditAccount.getId());
        } else if (leftover < 0){
            creditAccount.setSum(0);
            accountRepository.closeAccount(AccountStatus.CLOSED, creditAccount.getId());
            List<Account> accountsUsers = accountRepository.findByLogin(creditAccount.getUser().getLogin());
            if (accountsUsers != null){
                for (Account account : accountsUsers){
                    if (account instanceof DepositAccount){
                        account.setSum(account.getSum() + -leftover);
                        break;
                    }
                }
            }
        } else if (leftover == 0){
            creditAccount.setSum(0);
            accountRepository.closeAccount(AccountStatus.CLOSED, creditAccount.getId());
        }

    }
}
