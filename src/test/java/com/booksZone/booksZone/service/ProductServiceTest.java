package com.booksZone.booksZone.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.booksZone.booksZone.data.models.Products;
import com.booksZone.booksZone.data.repositories.ProductRepo;
import com.booksZone.booksZone.dtos.requests.AddProductRequest;
import com.booksZone.booksZone.dtos.response.AddProductResponse;
import com.booksZone.booksZone.services.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepo productRepo;

    @InjectMocks
    ProductServiceImpl productServiceImpl;

    @Test
    void addProductTest() {
        AddProductRequest request = new AddProductRequest();
        request.setProductName("Textbook");
        request.setProductPrice(2000);

        Products product = new Products();
        product.setProductName(request.getProductName());
        product.setProductPrice(request.getProductPrice());

        when(productRepo.save(any(Products.class))).thenAnswer(invocation -> {
            Products savedProduct = invocation.getArgument(0);
            savedProduct.setId(1L);
            return savedProduct;
        });

        AddProductResponse response = productServiceImpl.addProduct(request);

        assertNotNull(response);
        assertEquals("Textbook", response.getProductName()); 
}

}
