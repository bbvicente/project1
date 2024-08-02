package com.skillstorm.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.models.Product;
import com.skillstorm.models.Warehouse;
import com.skillstorm.repositories.ProductRepository;
import com.skillstorm.repositories.WarehouseRepository;
import com.skillstorm.models.WarehouseInventorySum;

@Service
public class ProductService {

    private ProductRepository repo;
    private WarehouseRepository wh_repo;
    
    public ProductService(ProductRepository repo, WarehouseRepository wh_repo){
        this.repo = repo;
        this.wh_repo = wh_repo;
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
     * The current inventory of the warehouse with a particular
     * @param id
     */
    public int currWarehouseInventory(int id){
        return repo.sumQuantityByWarehouse(id);
    }

    /**
     * List of the current inventory in all warehouses 
     * @return a list of the sum of the quantity of the products in each warehouse
     */
    public Iterable<WarehouseInventorySum> currTotalWarehouseInventory(){
        return repo.totalCurrWarehouseInventory();
    }
    
   /**
     * Creates a new product and adds it to the database or updates it if it exists
     * @param p
     * @return Product 
     */
    public Product saveProduct(Product p) {
        int wh_id = p.getWarehouse_id().getId();
        System.out.println(wh_id);
        Warehouse wh = wh_repo.findById(wh_id).get();
        System.out.println(wh);

        
        p.setWarehouse_id(wh);
        
        
        int capacity = wh.getCapacity();
        System.out.println(capacity);

        if((currWarehouseInventory(wh_id) + p.getQuantity()) < capacity){
            return repo.save(p);
        } else {
            throw new RuntimeException("Capacity exceeded");
        }
        
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
}
