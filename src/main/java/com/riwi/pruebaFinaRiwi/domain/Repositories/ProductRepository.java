package com.riwi.pruebaFinaRiwi.domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.pruebaFinaRiwi.domain.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    
}
