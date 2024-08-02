package com.skillstorm.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.models.Warehouse;
import com.skillstorm.repositories.WarehouseRepository;

@Service
public class WarehouseService {

    private WarehouseRepository repo;
    
    /**
     * Injection of the Warehouse Repository
     * @param repo
     */
    public WarehouseService(WarehouseRepository repo){
        this.repo = repo;
    }

    /**
     * Queries the Warehouse database and return a list of all the warehouses
     * @return list of warehouses
     */
    public Iterable<Warehouse> findAllWarehouses() {
        return repo.findAll();
    }
    
    /**
     * Queries the Warehouse database and return the warehouses with a particular id
     * @param id
     * @return Warehouse with id
     */
    public Optional<Warehouse> findWarehouseById(int id) {
        return repo.findById(id);
    }
    
    /**
     * Creates a new warehouse, adds it to the database or updates it if it exists
     * @param wh
     * @return Warehouse 
     */
    public Warehouse saveWarehouse(Warehouse wh) {
        return repo.save(wh);
    }
    
    /**
     * Updates the content of a warehouse or throws an error if it does not exist
     * @param id
     * @param wh
     * @return Warehouse 
     */
    public void updateWarehouse(int id, Warehouse wh) {

        if (!repo.existsById(id)) {
            throw new NoSuchElementException("The warehouse with id " + id + " does not exist!");
        }
        wh.setId(id);
        repo.save(wh);
    }

    /**
     * Deletes the warehouse with a particular id
     * @param id
     */
    public void deleteWarehouse(int id) {
        repo.deleteById(id);
    }

}
