package com.microservice.product.controller;

import com.microservice.product.entities.Product;
import com.microservice.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController
{
    @Autowired
    private IProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody Product product)
    {
        productService.save(product);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody Product newProduct, @PathVariable Long productId)
    {
        Product productDb = productService.findById(productId);
        if (productDb != null){
            newProduct.setProductId(productId);
            productService.update(newProduct);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId)
    {
        Product productDb = productService.findById(productId);
        if (productDb != null){
            productService.delete(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllProduct()
    {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/search/{productId}")
    public ResponseEntity<?> findById(@PathVariable Long productId)
    {
        return ResponseEntity.ok(productService.findById(productId));
    }

}