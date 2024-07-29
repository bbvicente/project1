package com.skillstorm.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.web.bind.annotation.CrossOrigin;

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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
@CrossOrigin(origins = "http://localhost:5173") //might change!!!
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Min(value = 4)
    @Max(value = 16)
    private String sku;

    @Column(length = 20)
    private String name;

    @Min(value = 0)
    @Max(value = 1000)
    private int quantity;

    @Column(length = 7)
    private String storageLocation;

    //dateIn
    //dateOut

    //warehouse_id (FK)
    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    @NotNull
    @JoinColumn(name = "warehouse_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Warehouse warehouse;

    public Product() {
    }

    public Product(int productId, String sku, String name, int quantity, String storageLocation) {
        this.productId = productId;
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.storageLocation = storageLocation;
    }

    public int getProductId() {
        return productId;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public Warehouse getWarehouse_id() {
        return warehouse;
    }

    public void setWarehouse_id(Warehouse warehouse_id) {
        this.warehouse = warehouse_id;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", sku=" + sku + ", name=" + name + ", quantity=" + quantity
                + ", storageLocation=" + storageLocation + ", warehouse" + (warehouse == null ? null : warehouse.getName()) + "]";
    }

}
