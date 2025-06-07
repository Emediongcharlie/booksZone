package com.booksZone.booksZone.data.repositories;

import com.booksZone.booksZone.data.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products, Long> {


}
