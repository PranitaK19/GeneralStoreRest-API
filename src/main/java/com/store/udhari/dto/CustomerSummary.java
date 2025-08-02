package com.store.udhari.dto;

public class CustomerSummary {

    private String name;
    private String mobile;
    private double totalUdhari;
    private double totalRepayment;
    private double remainingBalance;

    public CustomerSummary(String name, String mobile, double totalUdhari, double totalRepayment, double remainingBalance) {
        this.name = name;
        this.mobile = mobile;
        this.totalUdhari = totalUdhari;
        this.totalRepayment = totalRepayment;
        this.remainingBalance = remainingBalance;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public double getTotalUdhari() {
        return totalUdhari;
    }

    public double getTotalRepayment() {
        return totalRepayment;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }
}
