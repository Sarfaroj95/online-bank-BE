package com.online_bank.app.onlinebanking.Controller;


import com.online_bank.app.onlinebanking.Entity.User;
import com.online_bank.app.onlinebanking.Repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/api/v1")
public class UserController {

    @Autowired
    UserRepositoty userRepositoty;


    @PostMapping("/user")
    public void saveUser(@RequestBody User user){
           userRepositoty.save(user);
    }

    @GetMapping("user")
    public List<User> getAllUser(){
         return userRepositoty.findAll();
    }
}
