package com.booksZone.booksZone.dtos.response;

public class SearchByNameResponse {

    private String productName;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String message;
}
