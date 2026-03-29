package com.online_bank.app.onlinebanking.bankmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginBankUserRequest {
    private String username;
    private String password;
}
