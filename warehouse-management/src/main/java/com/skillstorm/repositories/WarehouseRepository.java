package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.models.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{


  /*
    TODO:
        get number of products in a warehouse
        get warehouse by name
        //int getCurrInventory();
 
     */

}

