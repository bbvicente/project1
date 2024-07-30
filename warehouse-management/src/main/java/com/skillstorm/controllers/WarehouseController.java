package com.skillstorm.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Warehouse;
import com.skillstorm.services.WarehouseService;

import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    
    private WarehouseService service;

    public WarehouseController(WarehouseService service){
        this.service = service;
    }

    @GetMapping
    public Iterable<Warehouse> findAllWarehouses() {
        return service.findAllWarehouses();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> findWarehouseById(@PathVariable int id) {
        Optional<Warehouse> wh = service.findWarehouseById(id);

        if (wh.isPresent()) {
            return ResponseEntity.ok(wh.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
    TODO:
        get all categories
        get warehouse current inventory
        get products in a warehouse
     */
    
    @PostMapping
    public void createWarehouse(@Valid @RequestBody Warehouse wh) {
        
        service.saveWarehouse(wh);
    }
    
    @PutMapping("/{id}")
    public void updateWarehouse(@PathVariable int id, @RequestBody Warehouse wh) {
        service.updateWarehouse(id, wh);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteWarehouse(@PathVariable int id) {
        service.deleteWarehouse(id);
    }
}
