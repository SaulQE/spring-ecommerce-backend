package com.microservice.category.service;

import com.microservice.category.entities.Category;

import java.util.List;

public interface ICategoryService
{
    List<Category> findAll();
    void save(Category category);
    void update(Category category);
    void delete(Long categoryId);
    Category findById(Long categoryId);
}
