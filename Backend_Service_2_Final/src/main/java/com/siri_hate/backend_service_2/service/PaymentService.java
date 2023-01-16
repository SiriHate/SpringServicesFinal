package com.siri_hate.backend_service_2.service;

import com.siri_hate.backend_service_2.model.Payment;
import com.siri_hate.backend_service_2.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import io.micrometer.core.annotation.Timed;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Timed(value = "ExtractSinglePaymentFromDB")
    public Optional<Payment> getPayment(Long id){
        return paymentRepository.findById(id);
    }

    @Timed("ExtractAllPaymentsFromDB")
    public List<Payment> getAllPayments(){
        return paymentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Timed("AddPaymentToDB")
    public Long addPayment(Payment payment){
        return paymentRepository.saveAndFlush(payment).getId();
    }
}