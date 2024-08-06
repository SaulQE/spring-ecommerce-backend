package com.microservice.product.service;

import com.microservice.product.client.CategoryClient;
import com.microservice.product.client.InventoryClient;
import com.microservice.product.controller.dto.CategoryDTO;
import com.microservice.product.controller.dto.InventoryDTO;
import com.microservice.product.entities.Product;
import com.microservice.product.http.response.InventoryByProductResponse;
import com.microservice.product.http.response.ProductWithCategoryResponse;
import com.microservice.product.repository.ProductRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryClient inventoryClient;

    @Autowired
    private CategoryClient categoryClient;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public InventoryByProductResponse findInventoriesByProductId(Long productId) {
        // Consultar el producto
        Product product = productRepository.findById(productId).orElse(new Product());

        // Obtener el inventario del Producto
        List<InventoryDTO> inventoryDTOList = inventoryClient.findAllInventoryByProductId(productId);

        return InventoryByProductResponse.builder()
                .name(product.getName())
                .descriptionShort(product.getDescriptionShort())
                .descriptionLong(product.getDescriptionLong())
                .price(product.getPrice())
                .inventoryDTOList(inventoryDTOList)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductWithCategoryResponse findProductWithCategory(Long productId) {
        Product product = productRepository.findById(productId).orElse(new Product());

        CategoryDTO categoryDTO = null;
        try {
            if (product.getCategoryId() != null) {
                categoryDTO = categoryClient.getCategoryById(product.getCategoryId());
            }
        }catch (FeignException.NotFound ignored){
        }

        return ProductWithCategoryResponse.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .descriptionShort(product.getDescriptionShort())
                .descriptionLong(product.getDescriptionLong())
                .price(product.getPrice())
                .categoryDTO(categoryDTO)
                .build();
    }
}
