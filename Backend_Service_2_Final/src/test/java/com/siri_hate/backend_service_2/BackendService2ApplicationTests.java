package com.siri_hate.backend_service_2;

import com.siri_hate.backend_service_2.model.Payment;
import com.siri_hate.backend_service_2.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BackendService2ApplicationTests {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void MainTest() {
        Payment initialPayment = new Payment(100F, "RUB",
                "18:15:00", "12.10.2021", "VISA");
        Long orderId = paymentService
          .addPayment(initialPayment);
        Payment retrievedPayment = paymentService
          .getPayment(orderId).orElse(null);

        assertNotNull(retrievedPayment, "Retrieved payment is not null");
        assertEquals(orderId, retrievedPayment.getId(), "Comparison of id");
        assertEquals(initialPayment.getCost(), retrievedPayment.getCost(),
                "Comparison of Cost");
        assertEquals(initialPayment.getCurrency(), retrievedPayment.getCurrency(),
                "Comparison of Currency");
        assertEquals(initialPayment.getTransactionTime(), retrievedPayment.getTransactionTime(),
                "Comparison of TransactionTime");
        assertEquals(initialPayment.getTransactionDate(), retrievedPayment.getTransactionDate(),
                "Comparison of TransactionDate");
        assertEquals(initialPayment.getPaymentServiceProvider(), retrievedPayment.getPaymentServiceProvider(),
                "Comparison of ServiceProvider");
    }

}
