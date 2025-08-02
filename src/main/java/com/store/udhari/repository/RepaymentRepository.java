package com.store.udhari.repository;

import com.store.udhari.model.Customer;
import com.store.udhari.model.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepaymentRepository extends JpaRepository<Repayment, Long> {
    List<Repayment> findByCustomer(Customer customer);
}
