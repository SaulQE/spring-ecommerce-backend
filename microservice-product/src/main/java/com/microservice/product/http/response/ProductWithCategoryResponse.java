package com.microservice.product.http.response;

import com.microservice.product.controller.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductWithCategoryResponse
{
    private Long productId;
    private String name;
    private String descriptionShort;
    private String descriptionLong;
    private Double price;
    private CategoryDTO categoryDTO;
}
