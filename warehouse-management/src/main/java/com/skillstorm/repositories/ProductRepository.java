package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    // get warehouse current inventory - product
    // get all categories


}
