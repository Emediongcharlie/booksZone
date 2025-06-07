package com.booksZone.booksZone.services;

import com.booksZone.booksZone.data.models.Customer;
import com.booksZone.booksZone.data.models.Sellers;
import com.booksZone.booksZone.data.repositories.CustomerRepo;
import com.booksZone.booksZone.data.repositories.SellersRepo;
import com.booksZone.booksZone.dtos.requests.*;
import com.booksZone.booksZone.dtos.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private SellersRepo sellersRepo;
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public SellersRegistrationResponse registerSeller(SellersRegistrationRequest registerRequest) {
        Sellers seller = new Sellers();
        seller.setFirstName(registerRequest.getFirstName());
        seller.setLastName(registerRequest.getLastName());
        seller.setEmail(registerRequest.getEmail());
        seller.setPassword(registerRequest.getPassword());
        sellersRepo.save(seller);
        SellersRegistrationResponse registerResponse = new SellersRegistrationResponse();
        registerResponse.setFirstName(seller.getFirstName());
        registerResponse.setId(seller.getId());
        registerResponse.setMessage("Successfully Registered");

        return registerResponse;
    }

    @Override
    public SellersLoginResponse loginSeller(SellersLoginRequest loginRequest) {
        Sellers farmer = sellersRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Email not found"));

        if (!farmer.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Incorrect email or Password");
        }

        SellersLoginResponse loginResponse = new SellersLoginResponse();
        loginResponse.setEmail(farmer.getEmail());
        loginResponse.setMessage("Successfully Logged In");
        return loginResponse;
    }

    @Override
    public CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest registerCustomerRequest) {
        Customer customer = new Customer();
        customer.setFirstName(registerCustomerRequest.getFirstName());
        customer.setLastName(registerCustomerRequest.getLastName());
        customer.setEmail(registerCustomerRequest.getEmail());
        customer.setPassword(registerCustomerRequest.getPassword());
        customerRepo.save(customer);
        CustomerRegistrationResponse registerResponse = new CustomerRegistrationResponse();
        registerResponse.setFirstName(customer.getFirstName());
        registerResponse.setId(customer.getId());
        registerResponse.setMessage("Successfully Registered");

        return registerResponse;
    }

    @Override
    public CustomerLoginResponse loginCustomer(CustomerLoginRequest loginCustomerRequest) {
        Customer customer = customerRepo.findByEmail(loginCustomerRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Email not found"));

        if (!customer.getPassword().equals(loginCustomerRequest.getPassword())) {
            throw new RuntimeException("Incorrect email or Password");
        }

        CustomerLoginResponse loginResponse = new CustomerLoginResponse();
        loginResponse.setEmail(customer.getEmail());
        loginResponse.setMessage("Successfully Logged In");
        return loginResponse;
    }

    public List<Customer> allCustomers(){
        return customerRepo.findAll();
    }

    public List<Sellers> allSellers(){
        return sellersRepo.findAll();
    }

    public FindSellerByIdResponse findSellerById(FindSellerByIdRequest request){
        Sellers seller = sellersRepo.findById(request.getId()).
                orElseThrow(() -> new RuntimeException("Sellers not found"));

        FindSellerByIdResponse findSellerByIdResponse = new FindSellerByIdResponse();
        findSellerByIdResponse.setFirstName(seller.getFirstName());
        findSellerByIdResponse.setId(seller.getId());
        findSellerByIdResponse.setMessage("user with id" + seller.getId() +"found");
        return findSellerByIdResponse;
    }

    public FindCustomerByIdResponse findCustomerById(FindCustomerByIdRequest request){
        Customer customer = customerRepo.findById(request.getId()).
                orElseThrow(() -> new RuntimeException("Sellers not found"));

        FindCustomerByIdResponse findCustomerByIdResponse = new FindCustomerByIdResponse();
        findCustomerByIdResponse.setFirstName(customer.getFirstName());
        findCustomerByIdResponse.setId(customer.getId());
        findCustomerByIdResponse.setMessage("user with id" + customer.getId() +"found");
        return findCustomerByIdResponse;
    }

}
