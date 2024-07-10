package com.microservice.product.http.response;

import com.microservice.product.controller.dto.InventoryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryByProductResponse
{
    private String name;
    private String descriptionShort;
    private String descriptionLong;
    private Double price;
    private List<InventoryDTO> inventoryDTOList;
}
