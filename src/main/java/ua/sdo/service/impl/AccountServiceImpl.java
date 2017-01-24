package ua.sdo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.sdo.model.accounts.Account;
import ua.sdo.repository.AccountRepository;
import ua.sdo.service.AccountService;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> findByLogin(String login) {
        return accountRepository.findByLogin(login);
    }

    @Override
    public List<Account> findByIdClient(int id) {
        return accountRepository.findByIdClient(id);
    }

    @Override
    public Account getById(int id) {
        return accountRepository.getOne(id);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public void updateSumAccount(double sum, int id) {
        accountRepository.updateSumAccount(sum, id);
    }

    @Override
    @Transactional
    public void closeAccount(int id) {
        accountRepository.closeAccount(id);
    }

}
