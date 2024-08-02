package com.skillstorm.controllers;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.skillstorm.models.WarehouseInventorySum;
import com.skillstorm.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174/"})
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    /**
     * HTTP GET request: List of all products
     * @return list of products
     */
    @GetMapping
    public Iterable<Product> findAllProducts() {
        return service.findAllProducts();
    }
    
    /**
     * HTTP GET request: gets the warehouses with a particular id
     * @param id
     * @return Warehouse with id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable int id) {
        Optional<Product> p = service.findProductById(id);

        if (p.isPresent()) {
            return ResponseEntity.ok(p.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * HTTP POST request: creates a new product, adds it to the database or updates it if it exists
     * @param p
     * @return Product 
     */
    @PostMapping
    public Product createWarehouse(@Valid @RequestBody Product p) {

        return service.saveProduct(p); //maybe check if wh exist in the data base by name
    }
    
    /**
     * HTTP PUT request: updates the content of a product
     * @param id
     * @param p
     * @return OK or NO_CONTENT HTTP status code
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateWarehouse(@PathVariable int id, @RequestBody Product p) {
        try {
            service.updateProduct(id, p); 
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    /**
     * HTTP DELETE request: deletes the product with a particular id
     * @param id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
    }

    @GetMapping("/current-inventory/{id}")
    public int currWarehouseInventory(@PathVariable int id){
        return service.currWarehouseInventory(id);
    }

    @GetMapping("/current-inventory")
    public Iterable<WarehouseInventorySum> currTotalWarehouseInventory(){
        return service.currWarehouseInventory();
    }
}
