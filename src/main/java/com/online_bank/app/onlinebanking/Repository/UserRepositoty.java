package com.online_bank.app.onlinebanking.Repository;

import com.online_bank.app.onlinebanking.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty  extends JpaRepository<User, Integer> {
}
