package com.skillstorm.models;

public class Category {

    private int categoryId;

    private String sport_category;

    private String brand;

    //product_id (FK)

    public Category() {
    }

    public Category(int categoryId, String sport_category, String brand) {
        this.categoryId = categoryId;
        this.sport_category = sport_category;
        this.brand = brand;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getSport_category() {
        return sport_category;
    }

    public String getBrand() {
        return brand;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setSport_category(String sport_category) {
        this.sport_category = sport_category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    
}
