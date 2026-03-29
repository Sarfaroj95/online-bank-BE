package com.online_bank.app.onlinebanking.Entity;

import com.online_bank.app.onlinebanking.Common.Enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Random;


@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;   // Primary key

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "aadhaar_number", nullable = false, unique = true)
    private String aadhaarNumber;

    @Column(name = "pan_number", nullable = false, unique = true)
    private String panNumber;

    @Column(name = "address", nullable = false)
    private String Address;


    // Auto Generate Below fields
    @Column(name = "cif_number", unique = true, nullable = false, length = 8)
    private String cifNumber;  // Unique CIF number

    @Enumerated(EnumType.STRING)
    @Column(name = "is_verification_status")
    private AccountStatus isVerificationStatus;

    @Column(name = "is_verified")
    private Boolean isVerified;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    public void prePersist() {
        this.isVerified = false; // default value
        this.isVerificationStatus = AccountStatus.PENDING; // default value
        this.isActive = false; // default valu
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.cifNumber = generateCifNumber(); // Generate CIF number on creation
    }


    private String generateCifNumber() {
        int number = 10000000 + new Random().nextInt(90000000); // ensures 8 digits
        return String.valueOf(number);
    }



}
