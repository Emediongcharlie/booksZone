package com.booksZone.booksZone.dtos.requests;

public class SearchByNameRequest {

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String productName;
}
