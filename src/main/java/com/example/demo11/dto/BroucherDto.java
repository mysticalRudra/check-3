package com.example.demo11.dto;


import java.math.BigDecimal;

public class BroucherDto {

    public BroucherDto(String brandName, int quantity, BigDecimal price, String liquorType,String priceType) {
		super();
		this.brandName = brandName;
		this.quantity = quantity;
		this.price = price;
		this.liquorType = liquorType;
		this.priceType = priceType;
	}

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

	public BroucherDto() {
		super();
	}

	// Getters and Setters
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
