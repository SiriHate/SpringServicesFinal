package com.siri_hate.backend_service_1.repository;

import com.siri_hate.backend_service_1.model.TripReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface TripReportRepository extends JpaRepository<TripReport, Long> {
    @Timed(value = "\"ExtractSingleOrderFromDB\"")
    @NonNull
    Optional<TripReport> findById(@NonNull Long id);

    @Timed("ExtractAllOrderFromDB")
    @NonNull
    List<TripReport> findAll(@NonNull Sort sort);
    @Timed("AddOrderToDB")
    @NonNull TripReport saveAndFlush(@NonNull TripReport paymentInfo);
}