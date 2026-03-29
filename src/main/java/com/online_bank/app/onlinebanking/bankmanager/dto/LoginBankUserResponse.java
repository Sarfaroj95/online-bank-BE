package com.online_bank.app.onlinebanking.bankmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginBankUserResponse {
    private String successType;
    private String msg;
    private String token;
    private String fail;
}
