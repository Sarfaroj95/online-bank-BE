package com.online_bank.app.onlinebanking.Repository;

import com.online_bank.app.onlinebanking.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
