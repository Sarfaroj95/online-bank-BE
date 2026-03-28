package com.online_bank.app.onlinebanking.Controller;


import com.online_bank.app.onlinebanking.Entity.Register;
import com.online_bank.app.onlinebanking.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/api/v1")
public class RegisterController {

    @Autowired
    RegisterRepository registerRepository;

    @PostMapping("/register")
    public void saveRegister(@RequestBody Register register){
        registerRepository.save(register);
    }

    @GetMapping("/register-list")
    public List<Register> getAllRegister() {
        return registerRepository.findAll();
    }
}
