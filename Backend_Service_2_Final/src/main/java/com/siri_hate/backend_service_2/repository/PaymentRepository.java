package com.siri_hate.backend_service_2.repository;

import com.siri_hate.backend_service_2.model.Payment;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Timed(value = "ExtractSinglePaymentFromDB")
    @NonNull Optional<Payment> findById(@NonNull Long id);

    @Timed("ExtractAllPaymentsFromDB")
    @NonNull List<Payment> findAll(@NonNull Sort sort);

    @Timed("AddPaymentToDB")
    @NonNull Payment saveAndFlush(@NonNull Payment paymentInfo);
}