package com.booksZone.booksZone.dtos.response;

public class FindProductByNameResponse {

    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    private Long id;

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getBookShopName() {
        return bookShopName;
    }

    public void setBookShopName(String bookShopName) {
        this.bookShopName = bookShopName;
    }

    private int productQuantity;
    private String bookShopName;
}
