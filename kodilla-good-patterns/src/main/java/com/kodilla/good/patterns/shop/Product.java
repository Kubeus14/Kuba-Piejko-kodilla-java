package com.kodilla.good.patterns.shop;

import java.math.BigDecimal;

public class Product {
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;

    public Product(String productName, String productDescription, BigDecimal productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return  "productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice;
    }
}
