package com.skillstorm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillstorm.models.Product;
import com.skillstorm.models.Warehouse;
import com.skillstorm.models.WarehouseInventorySum;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    // get warehouse current inventory - product
    // get all categories

    //@Query(value = "SELECT SUM(m.quantity) FROM Product m WHERE m.warehouse_id = ?1")
    // @Query(value = "SELECT SUM(quantity) FROM products WHERE warehouse_id = ?1", nativeQuery = true)
    // int currWarehouseInventoryById(int id);

    @Query("SELECT COALESCE(SUM(p.quantity),0) FROM Product p WHERE p.warehouse.id = :warehouseId")
    Integer sumQuantityByWarehouse(@Param("warehouseId") long warehouseId); 


    // @Query(value = "SELECT SUM(quantity) FROM products WHERE warehouse_id = ?1", nativeQuery = true)
    @Query(value = "SELECT wh.name AS name, SUM(p.quantity) AS quantity, wh.capacity AS capacity FROM Product p INNER JOIN Warehouse wh ON p.warehouse.id = wh.id  GROUP BY wh.id")
    List<WarehouseInventorySum> totalCurrWarehouseInventory();
    
}
