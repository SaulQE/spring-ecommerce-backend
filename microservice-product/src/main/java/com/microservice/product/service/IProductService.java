package com.microservice.product.service;

import com.microservice.product.entities.Product;

import java.util.List;

public interface IProductService
{
    List<Product> findAll();
    void save(Product product);
    void update(Product product);
    void delete(Long productId);
    Product findById(Long productId);
}
