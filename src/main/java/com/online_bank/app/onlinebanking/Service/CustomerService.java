package com.online_bank.app.onlinebanking.Service;

import com.online_bank.app.onlinebanking.Entity.CustomerEntity;
import com.online_bank.app.onlinebanking.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    @Autowired(required = true)
    private CustomerRepository customerRepository;

    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }

    public CustomerEntity getCustomerById(Long customer_id) {
        return customerRepository.findById(customer_id).orElse(null);
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerEntity approveCustomer(Long customer_id, Boolean isVerified) {
        CustomerEntity customer = customerRepository.findById(customer_id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customer_id));
        customer.setIsVerified(isVerified);
        return customerRepository.save(customer);
    }



}
