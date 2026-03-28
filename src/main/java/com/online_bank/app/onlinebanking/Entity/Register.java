package com.online_bank.app.onlinebanking.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Table(name="customer_registration")
@Entity
@Data
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name fields
    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    // Contact details
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    private LocalDate dateOfBirth;

    @Column(nullable = false, unique = true)
    private String aadhaarNumber;

    @Column(nullable = false, unique = true)
    private String panNumber;

    private String proofOfAddress; // file path or reference

    // Account details (set after verification)
    private String accountNumber;
    private String ifscCode;
    private String accountType;
    private Double initialDeposit;

    // Security setup (after account creation)
    private String username;
    private String password; // store encrypted
    private Boolean twoFactorEnabled;
    private Boolean isVerified;
    private Boolean isActive;



    private LocalDate createdAt;
    private LocalDate updatedAt;


}
