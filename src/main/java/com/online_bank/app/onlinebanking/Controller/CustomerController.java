package com.online_bank.app.onlinebanking.Controller;


import com.online_bank.app.onlinebanking.Entity.CustomerEntity;
import com.online_bank.app.onlinebanking.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/api/v1")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @PostMapping("/customers")
    public void createCustomer(@RequestBody CustomerEntity customerEntity){
        customerService.createCustomer(customerEntity);
    }

    @GetMapping("/customers/{customer_id}")
    public CustomerEntity getCustomerById(@PathVariable Long customer_id) {
        return customerService.getCustomerById(customer_id);
    }

    @GetMapping("/customer-list")
    public java.util.List<CustomerEntity> getAllCustomers() {
         return customerService.getAllCustomers();
    }

    @PatchMapping("/customers/{customer_id}/approve")
    public ResponseEntity<String> approveCustomer(@PathVariable Long customer_id, @RequestParam Boolean isVerified) {
        customerService.approveCustomer(customer_id, isVerified);
        return ResponseEntity.ok("Customer approval status updated successfully");
    }


}
