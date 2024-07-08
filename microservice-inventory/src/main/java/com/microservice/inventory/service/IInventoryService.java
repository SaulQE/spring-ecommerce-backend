package com.microservice.inventory.service;

import com.microservice.inventory.entities.Inventory;

import java.util.List;

public interface IInventoryService
{
    List<Inventory> findAll();
    void save(Inventory inventory);
    void update(Inventory inventory);
    void delete(Long inventoryId);
    Inventory findById(Long inventoryId);
}
