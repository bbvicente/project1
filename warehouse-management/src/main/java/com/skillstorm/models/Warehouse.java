package com.skillstorm.models;

public class Warehouse {

    private int warehouseId;

    private String name;

    private String city;

    private String state;

    private int capacity;

    public Warehouse() {
    }

    public Warehouse(int warehouseId, String name, String city, String state, int capacity) {
        this.warehouseId = warehouseId;
        this.name = name;
        this.city = city;
        this.state = state;
        this.capacity = capacity;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}
