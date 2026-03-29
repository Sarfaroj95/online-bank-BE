package com.online_bank.app.onlinebanking.bankmanager.service;

import com.online_bank.app.onlinebanking.bankmanager.entity.BankManagerRoleEntity;
import com.online_bank.app.onlinebanking.bankmanager.repository.BankManagerRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankManagerRoleService {
    private final BankManagerRoleRepository bankManagerRoleRepository;

    @Autowired
    public BankManagerRoleService(BankManagerRoleRepository bankManagerRoleRepository) {
        this.bankManagerRoleRepository = bankManagerRoleRepository;
    }

    public BankManagerRoleEntity addManagerRole(BankManagerRoleEntity entity) {
        return bankManagerRoleRepository.save(entity);
    }
}
