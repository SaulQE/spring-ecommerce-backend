package com.microservice.product.client;

import com.microservice.product.controller.dto.CategoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-category", url = "localhost:8080/api/category")
public interface CategoryClient
{
    @GetMapping("/search/{categoryId}")
    CategoryDTO getCategoryById(@PathVariable Long categoryId);
}
