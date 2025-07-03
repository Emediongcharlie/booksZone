package com.booksZone.booksZone.services;

import com.booksZone.booksZone.data.models.Products;
import com.booksZone.booksZone.data.repositories.ProductRepo;
import com.booksZone.booksZone.dtos.requests.AddProductRequest;
import com.booksZone.booksZone.dtos.requests.EditProductRequest;
import com.booksZone.booksZone.dtos.requests.FindProductByNameRequest;
import com.booksZone.booksZone.dtos.response.AddProductResponse;
import com.booksZone.booksZone.dtos.response.DeleteProductResponse;
import com.booksZone.booksZone.dtos.response.EditProductResponse;
import com.booksZone.booksZone.dtos.response.FindProductByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {

        if (addProductRequest == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        Products product = new Products();
        product.setProductName(addProductRequest.getProductName());
        product.setProductDescription(addProductRequest.getProductDescription());
        product.setProductPrice(addProductRequest.getProductPrice());
        product.setAuthorsName(addProductRequest.getAuthorName());
        product.setBookShopName(addProductRequest.getBookShopName());
        product.setProductQuantity(addProductRequest.getProductQuantity());
        productRepo.save(product);
        AddProductResponse addProductResponse = new AddProductResponse();
        addProductResponse.setProductName(product.getProductName());
        addProductResponse.setBookShopName(product.getBookShopName());
        addProductResponse.setMessage("Product with name " + addProductRequest.getProductName() + " added successfully");
        return addProductResponse;
    }

    @Override
    public DeleteProductResponse deleteProductById(Long productId) {
        Products product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepo.delete(product);

        DeleteProductResponse deleteProductResponse = new DeleteProductResponse();
        deleteProductResponse.setId(product.getId());
        deleteProductResponse.setMessage("Product with id " + productId + " deleted successfully");
        return deleteProductResponse;
    }


    @Override
    public FindProductByNameResponse findProduct(FindProductByNameRequest findProductByNameRequest) {
        Products product = productRepo.findByProductName(findProductByNameRequest.getProductName())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        FindProductByNameResponse findProductByNameResponse = new FindProductByNameResponse();
        findProductByNameResponse.setProductName(product.getProductName());
        findProductByNameResponse.setBookShopName(product.getBookShopName());
        findProductByNameResponse.setMessage("Product with name " + findProductByNameRequest.getProductName() + " found successfully");
        return findProductByNameResponse;
    }

    @Override
    public EditProductResponse editProduct(EditProductRequest editProductRequest) {
        Products product = productRepo.findById(editProductRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setProductName(editProductRequest.getProductName());
        product.setProductDescription(editProductRequest.getProductDescription());
        product.setProductPrice(editProductRequest.getProductPrice());
        product.setProductQuantity(editProductRequest.getProductQuantity());
        productRepo.save(product);
        EditProductResponse editProductResponse = new EditProductResponse();
        editProductResponse.setId(product.getId());
        editProductResponse.setMessage("Product with id " + editProductRequest.getProductId() + " edited successfully");
        return editProductResponse;
    }

    public List<Products> getAllProducts() {
        return productRepo.findAll();
    }
}
