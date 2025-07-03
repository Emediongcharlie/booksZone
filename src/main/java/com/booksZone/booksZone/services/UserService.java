package com.booksZone.booksZone.services;

import com.booksZone.booksZone.dtos.requests.CustomerLoginRequest;
import com.booksZone.booksZone.dtos.requests.CustomerRegistrationRequest;
import com.booksZone.booksZone.dtos.requests.SellersLoginRequest;
import com.booksZone.booksZone.dtos.requests.SellersRegistrationRequest;
import com.booksZone.booksZone.dtos.response.CustomerLoginResponse;
import com.booksZone.booksZone.dtos.response.CustomerRegistrationResponse;
import com.booksZone.booksZone.dtos.response.SellersLoginResponse;
import com.booksZone.booksZone.dtos.response.SellersRegistrationResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    SellersRegistrationResponse registerSeller(SellersRegistrationRequest registerRequest);
    SellersLoginResponse loginSeller(SellersLoginRequest loginRequest);
    CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest loginCustomerRequest);
    CustomerLoginResponse loginCustomer(CustomerLoginRequest loginCustomerRequest);
}
