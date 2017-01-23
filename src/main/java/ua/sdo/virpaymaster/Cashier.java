package ua.sdo.virpaymaster;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.sdo.repository.AccountRepository;
import ua.sdo.repository.PaymentRepository;

@Repository
public class Cashier {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentRepository paymentRepository;

//    @Scheduled(fixedDelay = 86400000)
//    private void refreshAllAccounts(){
//        List<Account> accounts = accountRepository.findAll();
//        if (accounts != null){
//            for (Account account: accounts){
//                if (account instanceof DepositAccount && account.getAccountStatus() == AccountStatus.OPEN){
//                    double newBalance = account.getSum() + (account.getSum() * account.getPercentage() / 100);
//                    double sumOfPayment = (account.getSum() * account.getPercentage() / 100);
//                    Payment payment = new Payment();
//                    payment.setSum(sumOfPayment);
//                    payment.setAccount(account);
//                    payment.setType(TypePayment.AdditionalDeposit);
//                    accountRepository.updateSumAccount(newBalance, account.getId());
//                    paymentRepository.saveAndFlush(payment);
//                    continue;
//                } else if (account instanceof CreditAccount && account.getAccountStatus() == AccountStatus.OPEN){
//                    double newBalance = account.getSum() + (account.getSum() * account.getPercentage() / 100);
//                    double sumOfPayment = (account.getSum() * account.getPercentage() / 100);
//                    Payment payment = new Payment();
//                    payment.setSum(sumOfPayment);
//                    payment.setAccount(account);
//                    payment.setType(TypePayment.AdditionalCreditEverymonthPercents);
//                    accountRepository.updateSumAccount(newBalance, account.getId());
//                    paymentRepository.saveAndFlush(payment);
//                    continue;
//                }
//            }
//        }
//    }

//    private void refreshCreditAccount(CreditAccount creditAccount, Payment payment){
//        double leftover = creditAccount.getSum() - payment.getSum();
//        if (leftover > 0 && payment.getSum() != 0){
//            creditAccount.setSum(creditAccount.getSum() - payment.getSum());
//            accountRepository.updateSumAccount(payment.getSum(), creditAccount.getId());
//        } else if (leftover < 0){
//            creditAccount.setSum(0);
//            accountRepository.closeAccount(AccountStatus.CLOSED, creditAccount.getId());
//            List<Account> accountsUsers = accountRepository.findByLogin(creditAccount.getUser().getLogin());
//            if (accountsUsers != null){
//                for (Account account : accountsUsers){
//                    if (account instanceof DepositAccount){
//                        account.setSum(account.getSum() + -leftover);
//                        break;
//                    }
//                }
//            }
//        } else if (leftover == 0){
//            creditAccount.setSum(0);
//            accountRepository.closeAccount(AccountStatus.CLOSED, creditAccount.getId());
//        }
//
//    }
}
