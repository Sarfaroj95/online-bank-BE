package com.online_bank.app.onlinebanking.Controller;


import com.online_bank.app.onlinebanking.Entity.AccountEntity;
import com.online_bank.app.onlinebanking.Repository.AccountRepository;
import com.online_bank.app.onlinebanking.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/api/v1")
public class AccountController {

    @Autowired
    AccountService accountService;


    @PostMapping("/accounts")
    public void createAccount(@RequestBody AccountEntity accountEntity){
       accountService.createAccount(accountEntity);
    }

    @GetMapping("/accounts/{account_id}")
    public AccountEntity getAccountById(@PathVariable Long account_id) {
        return accountService.getAccountById(account_id);
    }

    @GetMapping("/account-list")
    public ResponseEntity<?> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }
}
