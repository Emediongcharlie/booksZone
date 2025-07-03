package com.booksZone.booksZone.controller;

import com.booksZone.booksZone.data.models.Products;
import com.booksZone.booksZone.data.repositories.ProductRepo;
import com.booksZone.booksZone.dtos.requests.AddProductRequest;
import com.booksZone.booksZone.dtos.requests.DeleteProductRequest;
import com.booksZone.booksZone.dtos.requests.EditProductRequest;
import com.booksZone.booksZone.dtos.requests.FindProductByNameRequest;
import com.booksZone.booksZone.dtos.response.AddProductResponse;
import com.booksZone.booksZone.dtos.response.DeleteProductResponse;
import com.booksZone.booksZone.dtos.response.EditProductResponse;
import com.booksZone.booksZone.dtos.response.FindProductByNameResponse;
import com.booksZone.booksZone.services.ProductService;
import com.booksZone.booksZone.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/add-new-product/")
    private ResponseEntity<?> addNewProduct(@RequestBody AddProductRequest addProductRequest){
        try{
            AddProductResponse response = productService.addProduct(addProductRequest);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-product/{id}")
    private ResponseEntity<?> deleteProduct(@PathVariable Long id){
        try{
            DeleteProductResponse response = productService.deleteProductById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search-product/")
    private ResponseEntity<?> searchProduct(@RequestBody FindProductByNameRequest request){
        try{
            FindProductByNameResponse response = productService.findProduct(request);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("edit-product/")
    private ResponseEntity<?> updateProduct(@RequestBody EditProductRequest editProductRequest){
        try{
            EditProductResponse response = productService.editProduct(editProductRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get-all-products/")
    private ResponseEntity<?> getAllAvailableProducts(){
        try{
            List<Products> response = productServiceImpl.getAllProducts();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
