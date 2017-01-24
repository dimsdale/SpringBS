package ua.sdo.service;

import ua.sdo.model.accounts.Account;

import java.util.List;

public interface AccountService {


    void createAccount(Account account);
    List<Account> findByLogin(String login);
    List<Account> findByIdClient(int id);
    Account getById(int id);
    List<Account> getAll();
    void updateSumAccount(double sum, int id);
    void closeAccount(int id);



}
