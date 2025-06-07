package com.booksZone.booksZone.dtos.response;

public class AddProductResponse {

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String productName;
    private String message;
}
