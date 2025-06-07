package com.booksZone.booksZone.data.repositories;

import com.booksZone.booksZone.data.models.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellersRepo extends JpaRepository<Sellers, Long> {

    Optional<Sellers> findByEmail(String email);
}
