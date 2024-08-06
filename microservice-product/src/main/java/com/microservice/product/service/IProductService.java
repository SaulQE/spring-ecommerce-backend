package com.microservice.product.service;

import com.microservice.product.entities.Product;
import com.microservice.product.http.response.InventoryByProductResponse;
import com.microservice.product.http.response.ProductWithCategoryResponse;
import com.microservice.product.http.response.ProductWithDetailsResponse;

import java.util.List;

public interface IProductService
{
    List<Product> findAll();
    void save(Product product);
    void update(Product product);
    void delete(Long productId);
    Product findById(Long productId);
    InventoryByProductResponse findInventoriesByProductId(Long productId);
    ProductWithCategoryResponse findProductWithCategory(Long productId);
    ProductWithDetailsResponse findProductWithDetails(Long productId);
}
