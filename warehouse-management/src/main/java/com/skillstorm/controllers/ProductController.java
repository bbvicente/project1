package com.skillstorm.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Product;
import com.skillstorm.models.Warehouse;
import com.skillstorm.services.ProductService;
import com.skillstorm.services.WarehouseService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService service;

        public ProductController(ProductService service){
            this.service = service;
        }

        @GetMapping
        public Iterable<Product> findAllProducts() {
            return service.findAllProducts();
        }
        
        @GetMapping("/{id}")
        public ResponseEntity<Product> findProductById(@PathVariable int id) {
            Optional<Product> p = service.findProductById(id);

            if (p.isPresent()) {
                return ResponseEntity.ok(p.get());
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        /*
        TODO:
            get all categories
            get Product current inventory
            get products in a Product
        */
        
        @PostMapping
        public void createProduct(@Valid @RequestBody Product p) {
            // add some logic
            service.saveProduct(p);
        }
        
        @PutMapping("/{id}")
        public void updateProduct(@PathVariable int id, @RequestBody Product p) {
            service.updateProduct(id, p);
        }
        
        @DeleteMapping("/{id}")
        @ResponseStatus(code = HttpStatus.NO_CONTENT)
        public void deleteProduct(@PathVariable int id) {
            service.deleteProduct(id);
        }
}
