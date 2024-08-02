package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.models.Warehouse;

/**
 * Interface that extends JpaRepository so we can have access to thw query methods from JPA
 */
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{


}

