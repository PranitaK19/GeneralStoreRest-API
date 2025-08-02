package com.store.udhari.controller;

import com.store.udhari.dto.CustomerSummary;
import com.store.udhari.model.Customer;
import com.store.udhari.model.Udhari;
import com.store.udhari.model.Repayment;
import com.store.udhari.repository.CustomerRepository;
import com.store.udhari.repository.UdhariRepository;
import com.store.udhari.repository.RepaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/summary")
public class SummaryController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UdhariRepository udhariRepository;

    @Autowired
    private RepaymentRepository repaymentRepository;

    @GetMapping("/{name}")
    public CustomerSummary getCustomerSummary(@PathVariable String name) {
        Customer customer = customerRepository.findByName(name).orElseThrow();

        List<Udhari> udhariList = udhariRepository.findByCustomer(customer);
        List<Repayment> repaymentList = repaymentRepository.findByCustomer(customer);

        double totalUdhari = udhariList.stream().mapToDouble(Udhari::getAmount).sum();
        double totalRepayment = repaymentList.stream().mapToDouble(Repayment::getAmount).sum();
        double balance = totalUdhari - totalRepayment;

        return new CustomerSummary(
                customer.getName(),
                customer.getMobile(),
                totalUdhari,
                totalRepayment,
                balance
        );
        
    }

    }
