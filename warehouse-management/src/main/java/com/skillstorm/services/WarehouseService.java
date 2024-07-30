package com.skillstorm.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.models.Warehouse;
import com.skillstorm.repositories.WarehouseRepository;

@Service
public class WarehouseService {

    private WarehouseRepository repo;
    
    public WarehouseService(WarehouseRepository repo){
        this.repo = repo;
    }
    public Iterable<Warehouse> findAllWarehouses() {
        return repo.findAll();
    }
    
    public Optional<Warehouse> findWarehouseById(int id) {
        return repo.findById(id);
    }
    
    public void saveWarehouse(Warehouse wh) {

        if (repo.existsById(wh.getWarehouseId())) {
            repo.updateWarehouse(wh.getWarehouseId(), wh); 
        } else {
            repo.saveWarehouse(wh);
        }
    }
    
    public void updateWarehouse(int id, Warehouse wh) {

        if (!repo.existsById(id)) {
            repo.saveWarehouse(wh);
            throw new NoSuchElementException("The warehouse with id " + id + " does not exist.Creating a new warehouse!");
        }
        wh.setWarehouseId(id);
        repo.saveWarehouse(wh);
    }

    public void deleteWarehouse(int id) {
        repo.deleteWarehouse(id);
    }

    /*
    TODO:
        get all categories
        get warehouse current inventory
        get products in a warehouse
     */
}
