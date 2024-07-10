package com.microservice.product.client;

import com.microservice.product.controller.dto.InventoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-inventory", url = "localhost:8080/api/inventory")
public interface InventoryClient
{
    @GetMapping("/search-by-product/{productId}")
    List<InventoryDTO> findAllInventoryByProductId(@PathVariable Long productId);
}
