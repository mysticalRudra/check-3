package com.example.demo11.model;


import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Broucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serialNo;

    private String brandName;
    private int quantity;
    private BigDecimal price;
    private String liquorType;
    private String priceType;

    public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	// Getters and Setters
    public Long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLiquorType() {
        return liquorType;
    }

    public void setLiquorType(String liquorType) {
        this.liquorType = liquorType;
    }
}
