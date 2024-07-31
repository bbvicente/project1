package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skillstorm.models.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer>{

    // get warehouse current inventory - product
    // get all categories

    //@Query(value = "select sum(m.quantity) from Product as m where warehouse_id = id")
    //@Query(value = "SELECT SUM(m.quantity) FROM Product m WHERE m.warehouse_id = ?1")
    @Query(value = "SELECT SUM(quantity) FROM products WHERE warehouse_id = ?1", nativeQuery = true)
    int currWarehouseInventory(int id);

    // SELECT SUM(quantity) 
    // FROM products 
    // WHERE warehouse_id = 2;
}
