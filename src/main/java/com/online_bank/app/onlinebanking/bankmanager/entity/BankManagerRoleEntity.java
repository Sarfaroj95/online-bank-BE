package com.online_bank.app.onlinebanking.bankmanager.entity;

import com.online_bank.app.onlinebanking.Common.Enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bank_manger")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankManagerRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "bank_name", unique = true, nullable = false, length = 6)
    private String bankName;

    @Enumerated(EnumType.STRING)
    @Column(name = "bank_user_role", nullable = false)
    private UserRole bankUserRole;
}
