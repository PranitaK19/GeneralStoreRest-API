package com.store.udhari.repository;

import com.store.udhari.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByMobile(String mobile);

    Optional<Customer> findByName(String name);

    
    @Query("SELECT DISTINCT c FROM Customer c JOIN Udhari u ON u.customer.id = c.id")
    List<Customer> findCustomersWithUdhari();
}
//end