package com.liveasy.app.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * 
 * @author Vikash Katiyar
 * 
 */

@Entity
@Table(name = "logistics")
public class Logistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loadId")
    private Long loadId;

    @Column(name = "shipperId")
    private String shipperId;

    @Column(name = "loading_Point")
    private String loadingPoint;

    @Column(name = "unloading_Point")
    private String unloadingPoint;

    @Column(name = "product_Type")
    private String productType;

    @Column(name = "truck_Type")
    private String truckType;

    @Column(name = "no_Of_Trucks")
    private int noOfTrucks;

    @Column(name = "weight")
    private double weight;

    @Column(name = "comment")
    private String comment;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "Date")
    private LocalDate Date;

    public Logistics() {
    }

    public Logistics(String loadingPoint, String unloadingPoint, String productType, String truckType,
                     int noOfTrucks, double weight, String comment, String shipperId, LocalDate date) {
        this.loadingPoint = loadingPoint;
        this.unloadingPoint = unloadingPoint;
        this.productType = productType;
        this.truckType = truckType;
        this.noOfTrucks = noOfTrucks;
        this.weight = weight;
        this.comment = comment;
        this.shipperId = shipperId;
        this.Date = date;
    }

    public Long getLoadId() {
        return loadId;
    }

    public void setLoadId(Long loadId) {
        this.loadId = loadId;
    }

    public String getLoadingPoint() {
        return loadingPoint;
    }

    public void setLoadingPoint(String loadingPoint) {
        this.loadingPoint = loadingPoint;
    }

    public String getUnloadingPoint() {
        return unloadingPoint;
    }

    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public int getNoOfTrucks() {
        return noOfTrucks;
    }

    public void setNoOfTrucks(int noOfTrucks) {
        this.noOfTrucks = noOfTrucks;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShipperId() {
        return shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        this.Date = date;
    }
}
