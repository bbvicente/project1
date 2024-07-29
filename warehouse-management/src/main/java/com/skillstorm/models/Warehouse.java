package com.skillstorm.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "warehouses")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int warehouseId;

    @Column(length = 10)
    private String name;

    @Column(length = 20)
    private String city;

    @Column(length = 2)
    private String state;

    @Min(value = 0)
    @Max(value = 1000)
    private int capacity;

    @OneToMany(mappedBy = "product", targetEntity = Product.class)
    @JsonBackReference
    List<Product> products;
    
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

    @Override
    public String toString() {
        return "Warehouse [warehouseId=" + warehouseId + ", name=" + name + ", city=" + city + ", state=" + state
                + ", capacity=" + capacity + "]";
    }

}
