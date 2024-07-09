package com.microservice.inventory.controller;

import com.microservice.inventory.entities.Inventory;
import com.microservice.inventory.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController
{
    @Autowired
    private IInventoryService inventoryService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveInventory(@RequestBody Inventory inventory)
    {
        inventoryService.save(inventory);
    }

    @PutMapping("/update/{inventoryId}")
    public ResponseEntity<?> updateInventory(@RequestBody Inventory newInventory, @PathVariable Long inventoryId)
    {
        Inventory inventoryDb = inventoryService.findById(inventoryId);
        if (inventoryDb != null){
            newInventory.setInventoryId(inventoryId);
            inventoryService.update(newInventory);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{inventoryId}")
    public ResponseEntity<?> deleteInventory(@PathVariable Long inventoryId)
    {
        Inventory inventoryDb = inventoryService.findById(inventoryId);
        if (inventoryDb != null){
            inventoryService.delete(inventoryId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllInventory()
    {
        return ResponseEntity.ok(inventoryService.findAll());
    }

    @GetMapping("/search/{inventoryId}")
    public ResponseEntity<?> findById(@PathVariable Long inventoryId)
    {
        return ResponseEntity.ok(inventoryService.findById(inventoryId));
    }

}
