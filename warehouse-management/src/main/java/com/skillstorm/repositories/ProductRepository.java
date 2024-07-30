package com.skillstorm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skillstorm.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    /**
     * Queries the Product database and return a list of all the Product
     * @return list of Product
     */
    List<Product> findAll();

    /**
     * Queries the Product database and return a list of Product with a particular id
     * @param id
     * @return list of Product
     */
    Optional<Product> findById(Integer id);

     /**
     * Creates a new Product and adds it to the Product database
     * @param Product
     * @return Product
     */
    Product saveProduct(Product p);
    
    /**
     * Queries the Product database and updates the content of a Product with a partiuclar id
     * @param id
     * @param pproduct
     */
    void updateProduct(int id, Product p);

    /**
     * Queries the Product database and deletes the product with a particular id
     * @param id
     */
    void deleteProduct(int id);
}
