package com.online_bank.app.onlinebanking.bankmanager.entity;

import com.online_bank.app.onlinebanking.Common.Enums.BankUserAccess;
import com.online_bank.app.onlinebanking.Common.Enums.BankUserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bank_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_user_id")
    private Long managerId;

    @Column(name = "username", nullable = false, unique = true, length = 8)
    private String username;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Enumerated(EnumType.STRING)
    @Column(name = "bank_user_role", nullable = false)
    private BankUserRole bankUserRole;

    @Enumerated(EnumType.STRING)
    @Column(name = "bank_user_access", nullable = false)
    private BankUserAccess bankUserAccess;

    @Column(nullable = false, length = 12)
    private String password;

}
