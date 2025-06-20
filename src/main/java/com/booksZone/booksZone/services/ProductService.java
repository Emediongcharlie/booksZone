package com.booksZone.booksZone.services;

import com.booksZone.booksZone.dtos.requests.AddProductRequest;
import com.booksZone.booksZone.dtos.requests.DeleteProductRequest;
import com.booksZone.booksZone.dtos.requests.EditProductRequest;
import com.booksZone.booksZone.dtos.requests.FindProductByNameRequest;
import com.booksZone.booksZone.dtos.response.AddProductResponse;
import com.booksZone.booksZone.dtos.response.DeleteProductResponse;
import com.booksZone.booksZone.dtos.response.EditProductResponse;
import com.booksZone.booksZone.dtos.response.FindProductByNameResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    AddProductResponse addProduct(AddProductRequest addProductRequest);
    DeleteProductResponse deleteProductById(DeleteProductRequest deleteProductRequest);
    FindProductByNameResponse findProduct(FindProductByNameRequest findProductByNameRequest);
    EditProductResponse editProduct(EditProductRequest editProductRequest);
}
