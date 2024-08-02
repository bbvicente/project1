package com.skillstorm.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

/**
 * Product Entity
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    private String category;

    @Min(value = 0)
    @Max(value = 1000)
    private int quantity;

    @Column(length = 7)
    private String storageLocation;

    //warehouse_id (FK)
    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "warehouse_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Warehouse warehouse;

     /**
     * No-args constructor
     */
    public Product() {
    }

     /**
     * Constructor with arguments
     */
    public Product(int productId, String sku, String category, int quantity, String storageLocation) {
        this.id = productId;
        this.category = category;
        this.quantity = quantity;
        this.storageLocation = storageLocation;
    }

    /**
     * Returns the id of the product 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the category of product
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the quantity of the product in a warehouse
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the storage location of the warehouse the product belongs to
     * @return strorageLocation
     */
    public String getStorageLocation() {
        return storageLocation;
    }

     /**
     * Returns the id of the warehouse the product belongs to
     * @return warehouse
     */
    public Warehouse getWarehouse_id() {
        return warehouse;
    }

    /**
     * Sets the product id value
     */
    public void setId(int productId) {
        this.id = productId;
    }

    /**
     * Sets the product category value
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Sets the product quantity value to be added
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the product storage location value
     */
    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    /**
     * Sets the warehouse id value
     */
    public void setWarehouse_id(Warehouse warehouse_id) {
        this.warehouse = warehouse_id;
    }

    /**
     * Overrides the toString()
     * @return a String with all the product info
     */
    @Override
    public String toString() {
        return "Product [productId=" + id + ", category=" + category + ", quantity=" + quantity
                + ", storageLocation=" + storageLocation + ", warehouse" + (warehouse == null ? null : warehouse.getName()) + "]";
    }

}
