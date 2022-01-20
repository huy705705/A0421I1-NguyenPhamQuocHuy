package com.example.casestudy2.model.service;

import com.example.casestudy2.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String serviceName;
    private Integer serviceArea;
    private Double serviceCost;
    private Integer serviceMaxPeople;

    @ManyToOne(targetEntity = RentType.class)
    private RentType rentType;

    @ManyToOne(targetEntity = ServiceType.class)
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contracts;

    private String serviceStandardRoom;
    private String serviceDescriptionOtherConvenience;
    private Double servicePoolArea;
    private Integer serviceNumberOfFloors;

    public Service() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getServiceStandardRoom() {
        return serviceStandardRoom;
    }

    public void setServiceStandardRoom(String serviceStandardRoom) {
        this.serviceStandardRoom = serviceStandardRoom;
    }

    public String getServiceDescriptionOtherConvenience() {
        return serviceDescriptionOtherConvenience;
    }

    public void setServiceDescriptionOtherConvenience(String serviceDescriptionOtherConvenience) {
        this.serviceDescriptionOtherConvenience = serviceDescriptionOtherConvenience;
    }

    public Double getServicePoolArea() {
        return servicePoolArea;
    }

    public void setServicePoolArea(Double servicePoolArea) {
        this.servicePoolArea = servicePoolArea;
    }

    public Integer getServiceNumberOfFloors() {
        return serviceNumberOfFloors;
    }

    public void setServiceNumberOfFloors(Integer serviceNumberOfFloors) {
        this.serviceNumberOfFloors = serviceNumberOfFloors;
    }
}
