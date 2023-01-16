package com.siri_hate.backend_service_1;

import com.siri_hate.backend_service_1.model.TripReport;
import com.siri_hate.backend_service_1.service.TripReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BackendService1ApplicationTests {

    @Autowired
    private TripReportService tripReportService;

    @Test
    public void MainTest() {
        TripReport initialTripReport = new TripReport("ул.Подвиженка, д.3",
                "ул.Сергеева, д.4/1", 15, 5,
                5, "Ford Focus 3 2015", true);
        Long orderId = tripReportService
          .addTripReport(initialTripReport);
        TripReport retrievedTripReport = tripReportService
          .getTripReport(orderId).orElse(null);

        assertNotNull(retrievedTripReport, "Retrieved report is not null");
        assertEquals(orderId, retrievedTripReport.getId(), "Comparison of id");
        assertEquals(initialTripReport.getDeparturePoint(), retrievedTripReport.getDeparturePoint(),
                "Comparison of DeparturePoint");
        assertEquals(initialTripReport.getArrivalPoint(), retrievedTripReport.getArrivalPoint(),
                "Comparison of ArrivalPoint");
        assertEquals(initialTripReport.getTripTime(), retrievedTripReport.getTripTime(),
                "Comparison of TripTime");
        assertEquals(initialTripReport.getDriverAssessment(), retrievedTripReport.getDriverAssessment(),
                "Comparison of DriverAssessment");
        assertEquals(initialTripReport.getPassengerAssessment(), retrievedTripReport.getPassengerAssessment(),
                "Comparison of PassengerAssessment");
        assertEquals(initialTripReport.getCarModel(), retrievedTripReport.getCarModel(),
                "Comparison of CarModel");
        assertEquals(initialTripReport.getPaid(), retrievedTripReport.getPaid(),
                "Comparison of Paid");
    }

}
