package com.skillstorm.models;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
import jakarta.validation.constraints.Min;

/**
 * Warehouse Entity
 */
@Entity
@Table(name = "warehouses")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    private String name;

    @Column(length = 20)
    private String city;

    @Column(length = 2)
    private String state;

    @Min(value = 0)
    private int capacity;

    @OneToMany(mappedBy = "warehouse", targetEntity = Product.class)
    @Cascade(CascadeType.ALL)
    @JsonBackReference
    List<Product> products;
    
    /**
     * No-args constructor
     */
    public Warehouse() {
    }

    /**
     * Constructor with arguments
     */
    public Warehouse(int warehouseId, String name, String city, String state, int capacity) {
        this.id = warehouseId;
        this.name = name;
        this.city = city;
        this.state = state;
        this.capacity = capacity;
    }

    /**
     * Returns a warehouse id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the warehouse
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the city the warehouse is located
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the state the warehouse is located
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Returns the capacity of the warehouse
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the id value
     */
    public void setId(int warehouseId) {
        this.id = warehouseId;
    }

    /**
     * Sets the warehouse name value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the warehouse city value
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the warehouse state value
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets the warehouse capacity value
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Overrides the toString()
     * @return a String with all the warehouse info
     */
    @Override
    public String toString() {
        return "Warehouse [warehouseId=" + id + ", name=" + name + ", city=" + city + ", state=" + state
                + ", capacity=" + capacity + "]";
    }

}
