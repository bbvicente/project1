package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.models.Warehouse;
import java.util.List;
import java.util.Optional;


public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{

    /**
     * Queries the Warehouse database and return a list of all the warehouses
     * @return list of warehouses
     */
    List<Warehouse> findAll();

    /**
     * Queries the Warehouse database and return a list of warehouses with a particular id
     * @param id
     * @return list of warehouses
     */
    Optional<Warehouse> findById(Integer id);
    
     /**
     * Creates a new warehouse and adds it to the warehouses database
     * @param warehouse
     * @return Warehouse
     */
    Warehouse savWarehouse(Warehouse warehouse);
    
    /**
     * Queries the Warehouse database and updates the content of a warehouse with a partiuclar id
     * @param id
     * @param warehouse
     */
    void updateWarehouse(int id, Warehouse warehouse);

    /**
     * Queries the Warehouse database and deletes the warehouse with a particular id
     * @param id
     */
    void deleteWarehouse(int id);

  /*
    TODO:
        get all categories
        get warehouse current inventory
        get products in a warehouse
        get warehouse by name
     */

}

