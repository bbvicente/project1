package com.skillstorm.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Warehouse;
import com.skillstorm.services.WarehouseService;

import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

 
@RestController
@RequestMapping("/warehouses")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174/"})
public class WarehouseController {
    
    private WarehouseService service;

    public WarehouseController(WarehouseService service){
        this.service = service;
    }

    /**
     * HTTP GET request: List of all warehouses
     * @return list of warehouses
     */
    @GetMapping
    public Iterable<Warehouse> findAllWarehouses() {
        return service.findAllWarehouses();
    }
    
    /**
     * HTTP GET request: gets the warehouses with a particular id
     * @param id
     * @return Warehouse with id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> findWarehouseById(@PathVariable int id) {
        Optional<Warehouse> wh = service.findWarehouseById(id);

        if (wh.isPresent()) {
            return ResponseEntity.ok(wh.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * HTTP POST request: creates a new warehouse, adds it to the database or updates it if it exists
     * @param wh
     * @return Warehouse 
     */
    @PostMapping
    public Warehouse createWarehouse(@Valid @RequestBody Warehouse wh) {
        
        return service.saveWarehouse(wh); //maybe check if wh exist in the data base by name
    }
    
    /**
     * HTTP PUT request: updates the content of a warehouse
     * @param id
     * @param wh
     * @return OK or NO_CONTENT HTTP status code
     */
    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable int id, @RequestBody Warehouse wh) {
        try {
            service.updateWarehouse(id, wh); 
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    /**
     * HTTP DELETE request: deletes the warehouse with a particular id
     * @param id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteWarehouse(@PathVariable int id) {
        service.deleteWarehouse(id);
    }
}
