package ua.sdo.service;

import ua.sdo.model.accounts.Account;

import java.util.List;

public interface AccountService {



    List<Account> findByLogin(String login);
    List<Account> findById(int id);
    void updateSumAccount(double sum, int id);
    void closeAccount(int id);



}
