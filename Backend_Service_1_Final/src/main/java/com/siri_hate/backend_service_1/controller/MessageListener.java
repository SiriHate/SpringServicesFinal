package com.siri_hate.backend_service_1.controller;

import com.siri_hate.backend_service_1.config.MQConfig;
import com.siri_hate.backend_service_1.model.TripReport;
import com.siri_hate.backend_service_1.repository.TripReportRepository;
import com.siri_hate.backend_service_1.service.TripReportService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Objects;
import java.util.Optional;

@Component
public class MessageListener {

    private final TripReportService tripReportService;

    @Autowired
    public MessageListener(TripReportService tripReportService) {
        this.tripReportService = tripReportService;
    }

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(String message) {
        System.out.println(message);
            try {
                TripReport updatedOrder = tripReportService.getTripReportById(Long.parseLong(message)).get();
                updatedOrder.setPaid(true);
                tripReportService.addTripReport(updatedOrder);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

}