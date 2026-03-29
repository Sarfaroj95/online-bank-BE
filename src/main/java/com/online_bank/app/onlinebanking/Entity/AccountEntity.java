package com.online_bank.app.onlinebanking.Entity;

import com.online_bank.app.onlinebanking.Common.Enums.AccountsType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;


@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "customer_id", unique = true, nullable = false, length = 6)
    private String customerId;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "cif_number", unique = true, nullable = false, length = 8)
    private String cifNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountsType accountType;

    @Column(name = "balance", nullable = false)
    private BigDecimal currentBalance;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;


    @PrePersist
    public void prePersist() {
        this.customerId = generateCustomerId();
        this.accountNumber = generateAccountNumber();
        this.ifscCode = "IFSC0001234"; // static or branch-based
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date();
    }

    // Always 6 digits
    private String generateCustomerId() {
        int number = 100000 + new Random().nextInt(900000); // ensures 6 digits
        return String.valueOf(number);
    }

    // Always 11 digits starting with "40"
    private String generateAccountNumber() {
        long randomPart = 100000000L + new Random().nextInt(900000000);
        return "40" + randomPart; // "40" + 9 digits = 11 total
    }




}
