package com.online_bank.app.onlinebanking.bankmanager.controller;

import com.online_bank.app.onlinebanking.bankmanager.dto.LoginBankUserRequest;
import com.online_bank.app.onlinebanking.bankmanager.dto.LoginBankUserResponse;
import com.online_bank.app.onlinebanking.bankmanager.entity.BankUserEntity;
import com.online_bank.app.onlinebanking.bankmanager.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/api/v1")
public class BankUserController {
    private final BankUserService bankUserService;

    @Autowired
    public BankUserController(BankUserService bankUserService) {
        this.bankUserService = bankUserService;
    }

    @PostMapping("/bank-user")
    public ResponseEntity<BankUserEntity> addBankUser(@RequestBody BankUserEntity bankUserEntity) {
        BankUserEntity saved = bankUserService.addBankUser(bankUserEntity);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login-bankuser")
    public ResponseEntity<LoginBankUserResponse> loginBankUser(@RequestBody LoginBankUserRequest request) {
        LoginBankUserResponse response = bankUserService.loginBankUser(request);
        return ResponseEntity.ok(response);
    }
}
