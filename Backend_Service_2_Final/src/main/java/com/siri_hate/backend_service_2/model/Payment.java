package com.siri_hate.backend_service_2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float cost;

    private String currency;

    private String transactionTime;
    private String transactionDate;
    private String paymentServiceProvider;

    public Payment() {

    }

    public Payment(Float cost, String currency, String transactionTime, String transactionDate,
                   String paymentServiceProvider) {
        this.cost = cost;
        this.currency = currency;
        this.transactionTime = transactionTime;
        this.transactionDate = transactionDate;
        this.paymentServiceProvider = paymentServiceProvider;
    }

    public Long getId() {
        return id;
    }

    public Float getCost() {
        return cost;
    }

    public String getCurrency() {
        return currency;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getPaymentServiceProvider() {
        return paymentServiceProvider;
    }
}