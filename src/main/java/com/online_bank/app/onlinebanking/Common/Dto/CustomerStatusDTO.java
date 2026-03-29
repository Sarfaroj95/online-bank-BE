package com.online_bank.app.onlinebanking.Common.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerStatusDTO {
    private String isVerificationStatus;
    private Boolean isActive;
}
