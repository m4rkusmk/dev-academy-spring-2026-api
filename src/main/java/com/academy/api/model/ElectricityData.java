package com.academy.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "electricitydata")
public class ElectricityData {

    @Id
    private Integer id;

    @Column(columnDefinition = "DATE")
    private LocalDate date;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime starttime;

    @Column(columnDefinition = "numeric")
    private Double productionamount;

    @Column(columnDefinition = "numeric")
    private Double consumptionamount;

    @Column(columnDefinition = "numeric")
    private Double hourlyprice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public Double getProductionamount() {
        return productionamount;
    }

    public void setProductionamount(Double productionamount) {
        this.productionamount = productionamount;
    }

    public Double getConsumptionamount() {
        return consumptionamount;
    }

    public void setConsumptionamount(Double consumptionamount) {
        this.consumptionamount = consumptionamount;
    }

    public Double getHourlyprice() {
        return hourlyprice;
    }

    public void setHourlyprice(Double hourlyprice) {
        this.hourlyprice = hourlyprice;
    }
}
