package com.skillstorm.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.skillstorm.models.Product;
import com.skillstorm.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repo;
    
    public ProductService(ProductRepository repo){
        this.repo = repo;
    }
    public Iterable<Product> findAllProducts() {
        return repo.findAll();
    }
    
    public Optional<Product> findProductById(int id) {
        return repo.findById(id);
    }
    
    public void saveProduct(Product p) {

        if (repo.existsById(p.getProductId())) {
            repo.updateProduct(p.getProductId(), p);
            //Add an exception
        }
        repo.saveProduct(p);
    }
    
    public void updateProduct(int id, Product p) {

        if (!repo.existsById(id)) {
            repo.saveProduct(p);
            throw new NoSuchElementException("The product with id " + id + " does not exist.Creating a new product!");
        }
        p.setProductId(id);
        repo.saveProduct(p);
    }

    public void deleteProduct(int id) {
        repo.deleteProduct(id);
    }

    /*
    TODO:
        get all categories
        get Product current inventory
        get products in a Product
     */
}
