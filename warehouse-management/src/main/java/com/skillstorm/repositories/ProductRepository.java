package com.skillstorm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillstorm.models.Product;
import com.skillstorm.models.WarehouseInventorySum;

/**
 * Interface that extends JpaRepository so we can have access to thw query methods from JPA
 * Or we can customize our own query
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{

    // warehouse current inventory 
    @Query("SELECT COALESCE(SUM(p.quantity),0) FROM Product p WHERE p.warehouse.id = :warehouseId")
    Integer sumQuantityByWarehouse(@Param("warehouseId") long warehouseId); 

    //all warehouses current inventory 
    @Query(value = "SELECT wh.name AS name, COALESCE(SUM(p.quantity),0) AS quantity, wh.capacity AS capacity FROM Product p INNER JOIN Warehouse wh ON p.warehouse.id = wh.id  GROUP BY wh.id")
    List<WarehouseInventorySum> totalCurrWarehouseInventory();
    
}
