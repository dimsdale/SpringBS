package ua.sdo.service;

import ua.sdo.model.accounts.Account;
import ua.sdo.model.accounts.enums.AccountStatus;

import java.util.List;

public interface AccountService {



    List<Account> findByLogin(String login);
    void updateSumAccount(double sum, int id);
    void closeAccount(AccountStatus accountStatus, int id);



}
