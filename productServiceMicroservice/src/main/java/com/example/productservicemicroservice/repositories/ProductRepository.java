package com.example.productservicemicroservice.repositories;

import com.example.productservicemicroservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
