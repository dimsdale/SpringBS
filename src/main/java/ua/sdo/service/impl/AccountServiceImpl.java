package ua.sdo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sdo.model.accounts.Account;
import ua.sdo.repository.AccountRepository;
import ua.sdo.service.AccountService;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    protected AccountRepository accountRepository;

    @Override
    public List<Account> findByLogin(String login) {
        return accountRepository.findByLogin(login);
    }

    @Override
    public List<Account> findById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public void updateSumAccount(double sum, int id) {
        accountRepository.updateSumAccount(sum, id);
    }

    @Override
    public void closeAccount(int id) {
        accountRepository.closeAccount(id);
    }

}
