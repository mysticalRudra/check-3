package com.example.demo11.model;


import jakarta.persistence.*;

@Entity
@Table(name = "stock", uniqueConstraints = {@UniqueConstraint(columnNames = {"brand", "quantity"})})
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serialNumber;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int stockNumber;

    // Getters and Setters
    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }
}

