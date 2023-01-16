package com.siri_hate.backend_service_1.controller;

import com.siri_hate.backend_service_1.model.TripReport;
import com.siri_hate.backend_service_1.service.TripReportService;
import io.jaegertracing.internal.JaegerTracer;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TripReportController {

    public Tracer tracer = jaegerTracer();

    @Bean
    public io.opentracing.Tracer jaegerTracer() {
        JaegerTracer.Builder builder = new JaegerTracer.Builder("Service1");
        return builder.build();
    }

    private final TripReportService tripReportService;

    @Autowired
    public TripReportController(TripReportService tripReportService) {
        this.tripReportService = tripReportService;
    }

    @GetMapping("/display_report")
    public Optional<TripReport> getOrderById(@RequestParam Long id){
        Span span = tracer.buildSpan("GET /display_report").start();
        Optional<TripReport> result = tripReportService.getTripReport(id);
        span.finish();
        return result;
    }

    @GetMapping("/display_all_reports")
    public List<TripReport> getAllPayments(){
        Span span = tracer.buildSpan("GET /display_all_reports").start();
        List<TripReport> result = tripReportService.getAllTripReports();
        span.finish();
        return result;
    }

    @PostMapping("/add_report")
    public Long addOrder(@RequestBody TripReport tripReport){
        Span span = tracer.buildSpan("POST /add_report").start();
        Long result = tripReportService.addTripReport(tripReport);
        span.finish();
        return result;
    }

    @GetMapping("/health_check")
    public String healthCheck(){
        return "healthy";
    }

}
