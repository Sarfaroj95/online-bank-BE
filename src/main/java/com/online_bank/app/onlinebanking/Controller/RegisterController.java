package com.online_bank.app.onlinebanking.Controller;


import com.online_bank.app.onlinebanking.Entity.Register;
import com.online_bank.app.onlinebanking.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/bank/api/v1")
public class RegisterController {

    @Autowired
    RegisterRepository registerRepository;

    @PostMapping("/register")
    public ResponseEntity<?> saveRegister(@Valid @RequestBody Register register) {
        // Check for duplicate email
        Optional<Register> emailExists = registerRepository.findAll().stream()
            .filter(r -> r.getEmail().equalsIgnoreCase(register.getEmail()))
            .findFirst();
        if (emailExists.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new java.util.HashMap<String, Object>() {{
                    put("type", "email");
                    put("message", "Record already exists: Email");
                }});
        }

        // Check for duplicate phone
        Optional<Register> phoneExists = registerRepository.findAll().stream()
            .filter(r -> r.getPhone().equals(register.getPhone()))
            .findFirst();
        if (phoneExists.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new java.util.HashMap<String, Object>() {{
                    put("type", "phone");
                    put("message", "Record already exists: Phone");
                }});
        }

        // Check for duplicate Aadhaar
        Optional<Register> aadhaarExists = registerRepository.findAll().stream()
            .filter(r -> r.getAadhaarNumber().equals(register.getAadhaarNumber()))
            .findFirst();
        if (aadhaarExists.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new java.util.HashMap<String, Object>() {{
                    put("type", "aadhaar");
                    put("message", "Record already exists: Aadhaar number");
                }});
        }

        // Check for duplicate PAN
        Optional<Register> panExists = registerRepository.findAll().stream()
            .filter(r -> r.getPanNumber().equals(register.getPanNumber()))
            .findFirst();
        if (panExists.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new java.util.HashMap<String, Object>() {{
                    put("type", "pan");
                    put("message", "Record already exists: PAN number");
                }});
        }

        registerRepository.save(register);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new java.util.HashMap<String, Object>() {{
                put("type", "success");
                put("message", "Operation completed successfully — everything worked as intended");
            }});
    }

    @GetMapping("/register-list")
    public ResponseEntity<List<Register>> getAllRegister() {
        List<Register> registers = registerRepository.findAll();
        return new ResponseEntity<>(registers, HttpStatus.OK);
    }
}
