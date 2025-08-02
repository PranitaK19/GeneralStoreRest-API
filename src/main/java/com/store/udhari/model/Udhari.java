package com.store.udhari.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "udhari_entries")
public class Udhari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private double amount;

    private LocalDateTime dateTime;

    public Udhari() {
    }

    public Udhari(Customer customer, String itemName, double amount) {
        this.customer = customer;
        this.itemName = itemName;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
