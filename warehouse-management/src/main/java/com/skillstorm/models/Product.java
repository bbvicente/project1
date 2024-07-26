package com.skillstorm.models;

public class Product {

    private int productId;

    private String sku;

    private String name;

    private int quantity;

    private String storageLocation;

    //dateIn
    //dateOut
    //warehouse_id (FK)
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

    

    
}
