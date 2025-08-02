package com.store.udhari.controller;

import com.store.udhari.model.Customer;
import com.store.udhari.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

//@CrossOrigin(origins = "http://localhost:1996")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{mobile}")
    public Customer getCustomerByMobile(@PathVariable String mobile) {
        return customerRepository.findByMobile(mobile).orElse(null);
    }
    @GetMapping("/udhari-customers")
    public List<Customer> getCustomersWithUdhari() {
        return customerRepository.findCustomersWithUdhari();
    }

}
