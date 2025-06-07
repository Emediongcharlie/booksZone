package com.booksZone.booksZone.controller;

import com.booksZone.booksZone.data.models.Customer;
import com.booksZone.booksZone.data.models.Sellers;
import com.booksZone.booksZone.dtos.requests.*;
import com.booksZone.booksZone.dtos.response.*;
import com.booksZone.booksZone.services.UserService;
import com.booksZone.booksZone.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("register/seller/")
    public ResponseEntity<?> sellerRegistration(@RequestBody SellersRegistrationRequest request) {
        try{
            SellersRegistrationResponse response = userService.registerSeller(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("login/seller/")
    public ResponseEntity<?> sellerLogin(@RequestBody SellersLoginRequest request) {
        try{
            SellersLoginResponse response = userService.loginSeller(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("register/customer/")
    public ResponseEntity<?> customerRegistration(@RequestBody CustomerRegistrationRequest request) {
        try{
            CustomerRegistrationResponse response = userService.registerCustomer(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("login/customer/")
    public ResponseEntity<?> customerLogin(@RequestBody CustomerLoginRequest request) {
        try{
            CustomerLoginResponse response = userService.loginCustomer(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get-all-sellers")
    public ResponseEntity<?> getAllSellers() {
        try{
            List<Sellers> seller = userServiceImpl.allSellers();
            return new ResponseEntity<>(seller, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get-all-customers")
    public ResponseEntity<?> getAllCustomer() {
        try{
            List<Customer> seller = userServiceImpl.allCustomers();
            return new ResponseEntity<>(seller, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("search/seller/")
    public ResponseEntity<?> sellerFoundById(@RequestBody FindSellerByIdRequest request) {
        try{
            FindSellerByIdResponse response = userServiceImpl.findSellerById(request);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
