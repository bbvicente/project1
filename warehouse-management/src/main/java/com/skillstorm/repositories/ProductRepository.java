package com.skillstorm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skillstorm.models.Product;
import com.skillstorm.models.Warehouse;


public interface ProductRepository extends JpaRepository<Product, Integer>{

    // get warehouse current inventory - product
    // get all categories

    //@Query(value = "SELECT SUM(m.quantity) FROM Product m WHERE m.warehouse_id = ?1")
    @Query(value = "SELECT SUM(quantity) FROM products WHERE warehouse_id = ?1", nativeQuery = true)
    int currWarehouseInventoryById(int id);

    // @Query(value = "SELECT SUM(quantity) FROM products WHERE warehouse_id = ?1", nativeQuery = true)
    @Query(value = "SELECT wh.name, SUM(p.quantity), wh.capacity FROM products p INNER JOIN warehouses wh ON p.warehouse_id = wh.id  GROUP BY wh.id, wh.name", nativeQuery = true)
    List<Product> totalCurrWarehouseInventory(Warehouse wh);
    
}
