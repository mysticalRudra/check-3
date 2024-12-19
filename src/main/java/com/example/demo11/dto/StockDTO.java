package com.example.demo11.dto;

public class StockDTO {

    private String brand;
    private int quantity;
    private int stockNumber;

    // Constructors
    public StockDTO(String brand, int quantity, int stockNumber) {
        this.brand = brand;
        this.quantity = quantity;
        this.stockNumber = stockNumber;
    }

    // Getters and Setters
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

