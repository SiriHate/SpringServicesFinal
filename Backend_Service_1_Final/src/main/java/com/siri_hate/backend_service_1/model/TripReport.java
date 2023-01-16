package com.siri_hate.backend_service_1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class TripReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isPaid;
    private String departurePoint;
    private String arrivalPoint;

    private int tripTime;

    private int driverAssessment;

    private int passengerAssessment;
    private String carModel;

    public TripReport(String departurePoint, String arrivalPoint, int tripTime, int driverAssessment,
                      int passengerAssessment, String carModel, boolean isPaid) {
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.tripTime = tripTime;
        this.driverAssessment = driverAssessment;
        this.passengerAssessment = passengerAssessment;
        this.carModel = carModel;
        this.isPaid = isPaid;
    }

    public Long getId() {
        return id;
    }

    public TripReport() {
        this.isPaid = false;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public int getTripTime() {
        return tripTime;
    }

    public void setTripTime(int tripTime) {
        this.tripTime = tripTime;
    }

    public int getDriverAssessment() {
        return driverAssessment;
    }

    public void setDriverAssessment(int driverAssessment) {
        this.driverAssessment = driverAssessment;
    }

    public int getPassengerAssessment() {
        return passengerAssessment;
    }

    public void setPassengerAssessment(int passengerAssessment) {
        this.passengerAssessment = passengerAssessment;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Boolean getPaid() { return isPaid; }

    public void setPaid(Boolean paid) { isPaid = paid; }

}