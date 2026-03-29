package com.online_bank.app.onlinebanking.bankmanager.repository;

import com.online_bank.app.onlinebanking.bankmanager.entity.BankManagerRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankManagerRoleRepository extends JpaRepository<BankManagerRoleEntity, Long> {
}
