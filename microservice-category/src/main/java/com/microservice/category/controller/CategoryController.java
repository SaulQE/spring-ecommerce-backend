package com.microservice.category.controller;

import com.microservice.category.entities.Category;
import com.microservice.category.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController
{
    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCategory(@RequestBody Category category)
    {
        categoryService.save(category);
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<?> updateCategory(@RequestBody Category newCategory, @PathVariable Long categoryId)
    {
        Category categoryDb = categoryService.findById(categoryId);
        if (categoryDb != null)
        {
            newCategory.setCategoryId(categoryId);
            categoryService.update(newCategory);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId)
    {
        Category categoryDb = categoryService.findById(categoryId);
        if (categoryDb != null)
        {
            categoryService.delete(categoryId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCategory()
    {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/search/{categoryId}")
    public ResponseEntity<?> findById(@PathVariable Long categoryId)
    {
        return ResponseEntity.ok(categoryService.findById(categoryId));
    }

}
