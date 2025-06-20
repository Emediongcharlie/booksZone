package com.booksZone.booksZone.dtos.response;

public class EditProductResponse {

    private Long id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String message;
}
