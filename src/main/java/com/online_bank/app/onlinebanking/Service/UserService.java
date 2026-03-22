package com.online_bank.app.onlinebanking.Service;

import com.online_bank.app.onlinebanking.Entity.User;
import com.online_bank.app.onlinebanking.Repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {


    @Autowired
    UserRepositoty userRepositoty;

    public List<User> getAllUser(){
        return userRepositoty.findAll();
    }
}
