package com.booksZone.booksZone.data.repositories;

import com.booksZone.booksZone.data.models.Customer;
import com.booksZone.booksZone.data.models.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
}
