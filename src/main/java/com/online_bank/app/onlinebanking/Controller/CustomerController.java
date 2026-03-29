package com.online_bank.app.onlinebanking.Controller;


import com.online_bank.app.onlinebanking.Common.Dto.CustomerStatusDTO;
import com.online_bank.app.onlinebanking.Entity.CustomerEntity;
import com.online_bank.app.onlinebanking.Repository.CustomerRepository;
import com.online_bank.app.onlinebanking.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/bank/api/v1")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/customers")
    public void createCustomer(@RequestBody CustomerEntity customerEntity){
        customerService.createCustomer(customerEntity);
    }

    @GetMapping("/customers/{customer_id}")
    public CustomerEntity getCustomerById(@PathVariable Long customer_id) {
        return customerService.getCustomerById(customer_id);
    }

    @GetMapping("/customerList")
    public java.util.List<CustomerEntity> getAllCustomers() {
         return customerService.getAllCustomers();
    }

    @PatchMapping("/customerVerify/{customer_id}")
    public ResponseEntity<String> approveCustomer(
            @PathVariable Long customer_id,
            @RequestParam Boolean isVerified) {

        customerService.approveCustomer(customer_id, isVerified);
        return ResponseEntity.ok("Customer approval status updated successfully");
    }

    @PatchMapping("/updateCustomerStatus/{customer_id}")
    public ResponseEntity<HashMap<String, Object>> updateStatus(
            @PathVariable Long customer_id,
            @RequestBody CustomerStatusDTO dto) {
         customerService.updateCustomerStatus(customer_id, dto);
         return ResponseEntity.status(HttpStatus.OK).body(new java.util.HashMap<String, Object>() {{
             put("type", "success");
             put("message", "Customer status updated successfully");
         }});
    }



}
