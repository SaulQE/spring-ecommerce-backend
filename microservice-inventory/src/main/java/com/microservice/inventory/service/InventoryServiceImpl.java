package com.microservice.inventory.service;

import com.microservice.inventory.entities.Inventory;
import com.microservice.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryServiceImpl implements IInventoryService
{
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Transactional
    @Override
    public void update(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    @Transactional
    public void delete(Long inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public Inventory findById(Long inventoryId) {
        return inventoryRepository.findById(inventoryId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inventory> findAllProduct(Long productId) {
        return inventoryRepository.findAllProduct(productId);
    }
}
