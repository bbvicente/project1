package com.skillstorm.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Product;
import com.skillstorm.models.Warehouse;
import com.skillstorm.repositories.ProductRepository;
import com.skillstorm.repositories.WarehouseRepository;

@Service
public class ProductService {

    private ProductRepository repo;
    //private WarehouseRepository wh;
    
    public ProductService(ProductRepository repo){
        this.repo = repo;
       // this.wh = wh;
    }

    /**
     * Queries the Product database and return a list of all the products
     * @return list of products
     */
    public Iterable<Product> findAllProducts() {
        return repo.findAll();
    }
    
    /**
     * Queries the Product database and return the product with a particular id
     * @param id
     * @return Product with id
     */
    public Optional<Product> findProductById(int id) {
        return repo.findById(id);
    }
    
   /**
     * Creates a new product and adds it to the database or updates it if it exists
     * @param p
     * @return Product 
     */
    public Product saveProduct(Product p) {
        // if((repo.currWarehouseInventory(p.getId() + p.getQuantity()) > )
        return repo.save(p);
    }
    
    /**
     * Updates the content of a product or throws an error if it does not exist
     * @param id
     * @param p
     * @return Warehouse 
     */
    public void updateProduct(int id, Product p) {

        if (!repo.existsById(id)) {
            throw new NoSuchElementException("The warehouse with id " + id + " does not exist!");
        }
        p.setId(id);
        repo.save(p);
    }

    /**
     * Deletes the product with a particular id
     * @param id
     */
    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    // public List<Product> currWarehouseInventory(@Param("courseId") Long courseId){
    //     System.out.println(repo.currWarehouseInventory(wh));
    //     return repo.currWarehouseInventory(wh);
    // }
}
