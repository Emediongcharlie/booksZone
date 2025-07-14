package com.booksZone.booksZone.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.booksZone.booksZone.data.models.Customer;
import com.booksZone.booksZone.data.models.Sellers;
import com.booksZone.booksZone.data.repositories.CustomerRepo;
import com.booksZone.booksZone.data.repositories.SellersRepo;
import com.booksZone.booksZone.dtos.requests.CustomerLoginRequest;
import com.booksZone.booksZone.dtos.requests.CustomerRegistrationRequest;
import com.booksZone.booksZone.dtos.requests.SellersLoginRequest;
import com.booksZone.booksZone.dtos.requests.SellersRegistrationRequest;
import com.booksZone.booksZone.dtos.response.CustomerLoginResponse;
import com.booksZone.booksZone.dtos.response.CustomerRegistrationResponse;
import com.booksZone.booksZone.dtos.response.SellersLoginResponse;
import com.booksZone.booksZone.dtos.response.SellersRegistrationResponse;
import com.booksZone.booksZone.services.UserService;
import com.booksZone.booksZone.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    SellersRepo sellersRepo;

    @Mock
    CustomerRepo customerRepo;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;
    
    @InjectMocks
    UserServiceImpl userService;

   @Test
    void registerNewSellerTest() {
        
        SellersRegistrationRequest request = new SellersRegistrationRequest();
        request.setFirstName("Emediong");
        request.setEmail("emediong@gmail.com");
        request.setLastName("charlie");
        request.setPassword("2222");

        Mockito.when(passwordEncoder.encode("2222")).thenReturn("encoded-password");

        Mockito.when(sellersRepo.save(any(Sellers.class))).thenAnswer(invocation -> {
            Sellers s = invocation.getArgument(0);
            s.setId(1L);
            return s;
        });

        SellersRegistrationResponse response = userService.registerSeller(request);

        assertNotNull(response);
        assertEquals("Emediong", response.getFirstName());
    }

    @Test
    void sellerLoginTest(){

        SellersLoginRequest request = new SellersLoginRequest();
        request.setEmail("emediong@gmail.com");
        request.setPassword("2222");

        Sellers seller = new Sellers();
        seller.setEmail(request.getEmail());
        seller.setPassword(request.getPassword());

        when(sellersRepo.findByEmail("emediong@gmail.com")).thenReturn(Optional.of(seller));

        SellersLoginResponse response = userService.loginSeller(request);

        assertNotNull((response));
        assertEquals("emediong@gmail.com", response.getEmail());

    }

    @Test
    void registerNewCustomerTest() {
        
        CustomerRegistrationRequest request = new CustomerRegistrationRequest();
        request.setFirstName("Emediong");
        request.setEmail("emediong@gmail.com");
        request.setLastName("charlie");
        request.setPassword("2222");

        Mockito.when(passwordEncoder.encode("2222")).thenReturn("encoded-password");

        Mockito.when(customerRepo.save(any(Customer.class))).thenAnswer(invocation -> {
            Customer s = invocation.getArgument(0);
            s.setId(1L);
            return s;
        });

        CustomerRegistrationResponse response = userService.registerCustomer(request);

        assertNotNull(response);
        assertEquals("Emediong", response.getFirstName());
    }

     @Test
    void customerLoginTest(){

        CustomerLoginRequest request = new CustomerLoginRequest();
        request.setEmail("emediong@gmail.com");
        request.setPassword("2222");

        Customer customer = new Customer();
        customer.setEmail(request.getEmail());
        customer.setPassword(request.getPassword());

        when(customerRepo.findByEmail("emediong@gmail.com")).thenReturn(Optional.of(customer));

        CustomerLoginResponse response = userService.loginCustomer(request);

        assertNotNull((response));
        assertEquals("emediong@gmail.com", response.getEmail());

    }

    
}
