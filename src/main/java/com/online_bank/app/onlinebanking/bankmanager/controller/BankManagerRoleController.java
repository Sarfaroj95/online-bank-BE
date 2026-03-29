package com.online_bank.app.onlinebanking.bankmanager.controller;

import com.online_bank.app.onlinebanking.bankmanager.entity.BankManagerRoleEntity;
import com.online_bank.app.onlinebanking.bankmanager.service.BankManagerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/api/v1")
public class BankManagerRoleController {
    private final BankManagerRoleService bankManagerRoleService;

    @Autowired
    public BankManagerRoleController(BankManagerRoleService bankManagerRoleService) {
        this.bankManagerRoleService = bankManagerRoleService;
    }

    @PostMapping("/manager-role")
    public ResponseEntity<BankManagerRoleEntity> addManagerRole(@RequestBody BankManagerRoleEntity entity) {
        BankManagerRoleEntity saved = bankManagerRoleService.addManagerRole(entity);
        return ResponseEntity.ok(saved);
    }
}
