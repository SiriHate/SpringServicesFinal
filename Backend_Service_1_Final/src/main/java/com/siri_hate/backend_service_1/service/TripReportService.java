package com.siri_hate.backend_service_1.service;

import com.siri_hate.backend_service_1.model.TripReport;
import com.siri_hate.backend_service_1.repository.TripReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import io.micrometer.core.annotation.Timed;
import java.util.List;
import java.util.Optional;

@Service
public class TripReportService {

    private final TripReportRepository tripReportRepository;

    @Autowired
    public TripReportService(TripReportRepository tripReportRepository) {
        this.tripReportRepository = tripReportRepository;
    }

    @Timed("ExtractSingleOrderFromDB")
    public Optional<TripReport> getTripReport(Long id){
        return tripReportRepository.findById(id);
    }

    @Timed("ExtractAllOrderFromDB")
    public List<TripReport> getAllTripReports(){
        return tripReportRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Timed("AddOrderToDB")
    public Long addTripReport(TripReport tripReport){
        return tripReportRepository.saveAndFlush(tripReport).getId();
    }

    @Timed("ExtractSingleOrderFromDB")
    public Optional<TripReport> getTripReportById(Long id){
        return tripReportRepository.findById(id);
    }

}