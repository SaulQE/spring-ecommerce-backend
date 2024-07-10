package com.microservice.inventory.repository;

import com.microservice.inventory.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>
{
    @Query("SELECT i FROM Inventory i WHERE i.productId = :productId")
    List<Inventory> findAllProduct(Long productId);
}
