package com.online_bank.app.onlinebanking.Service;

import com.online_bank.app.onlinebanking.Entity.AccountEntity;
import com.online_bank.app.onlinebanking.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService {

    @Autowired(required = true)
    private AccountRepository accountRepository;

    public AccountEntity createAccount(AccountEntity accountEntity) {
        return accountRepository.save(accountEntity);
    }

    public AccountEntity getAccountById(Long account_id) {
        return accountRepository.findById(account_id).orElse(null);
    }


    public List<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }
}
