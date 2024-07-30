package com.skillstorm.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.aspects.AlreadyExistsException;
import com.skillstorm.models.Product;
import com.skillstorm.repositories.ProductRepository;

@Service
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
    
    public void saveProduct(Product p) throws AlreadyExistsException {

        if (repo.existsById(p.getProductId())) {
            repo.updateProduct(p.getProductId(), p);  //update just the quantity
            throw new AlreadyExistsException("Product with id " + p.getProductId() + " already exists in the warehouse. Updating " + p.getCategory());
        }
        repo.saveProduct(p);

        //check if add new product exceeds the capacity of the warehouse
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

}
