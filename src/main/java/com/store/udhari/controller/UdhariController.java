package com.store.udhari.controller;

import com.store.udhari.model.Customer;
import com.store.udhari.model.Udhari;
import com.store.udhari.repository.CustomerRepository;
import com.store.udhari.repository.UdhariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/api/udhari")
public class UdhariController {

    @Autowired
    private UdhariRepository udhariRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public Udhari addUdhari(@RequestParam String name,
                            @RequestParam String itemName,
                            @RequestParam double amount) {
        Customer customer = customerRepository.findByName(name).orElseThrow();
        Udhari udhari = new Udhari(customer, itemName, amount);
        return udhariRepository.save(udhari);
    }

    @GetMapping("/{name}")
    public List<Udhari> getUdhariByCustomer(@PathVariable String name) {
        Customer customer = customerRepository.findByName(name).orElseThrow();
        return udhariRepository.findByCustomer(customer);
    }

}
