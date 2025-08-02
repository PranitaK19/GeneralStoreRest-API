package com.store.udhari.repository;

import com.store.udhari.model.Udhari;
import com.store.udhari.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UdhariRepository extends JpaRepository<Udhari, Long> {
    List<Udhari> findByCustomer(Customer customer);
}
