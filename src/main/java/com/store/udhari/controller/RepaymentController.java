package com.store.udhari.controller;

import com.store.udhari.model.Customer;
import com.store.udhari.model.Repayment;
import com.store.udhari.repository.CustomerRepository;
import com.store.udhari.repository.RepaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/repayments")
public class RepaymentController {

    @Autowired
    private RepaymentRepository repaymentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public Repayment addRepayment(@RequestParam String name,
                                   @RequestParam double amount) {
        Customer customer = customerRepository.findByName(name).orElseThrow();
        Repayment repayment = new Repayment(customer, amount);
        return repaymentRepository.save(repayment);
    }

    @GetMapping("/{name}")
    public List<Repayment> getRepayments(@PathVariable String name) {
        Customer customer = customerRepository.findByName(name).orElseThrow();
        return repaymentRepository.findByCustomer(customer);
    }

}
