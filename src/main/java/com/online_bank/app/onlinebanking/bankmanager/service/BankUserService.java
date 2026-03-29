package com.online_bank.app.onlinebanking.bankmanager.service;

import com.online_bank.app.onlinebanking.bankmanager.dto.LoginBankUserRequest;
import com.online_bank.app.onlinebanking.bankmanager.dto.LoginBankUserResponse;
import com.online_bank.app.onlinebanking.bankmanager.entity.BankUserEntity;
import com.online_bank.app.onlinebanking.bankmanager.repository.BankUserRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankUserService {
    private final BankUserRepository bankUserRepository;

    @Autowired
    public BankUserService(BankUserRepository bankUserRepository) {
        this.bankUserRepository = bankUserRepository;
    }

    public BankUserEntity addBankUser(BankUserEntity entity) {
        return bankUserRepository.save(entity);
    }

    public LoginBankUserResponse loginBankUser(LoginBankUserRequest request) {
        Optional<BankUserEntity> userOpt = bankUserRepository.findAll().stream()
            .filter(u -> u.getUsername().equals(request.getUsername()) && u.getPassword().equals(request.getPassword()))
            .findFirst();
        LoginBankUserResponse response = new LoginBankUserResponse();
        if (userOpt.isPresent()) {
            response.setSuccessType("success");
            response.setMsg("log in success");
            response.setToken(UUID.randomUUID().toString());
        } else {
            response.setFail("log in failure please try again");
        }
        return response;
    }
}
