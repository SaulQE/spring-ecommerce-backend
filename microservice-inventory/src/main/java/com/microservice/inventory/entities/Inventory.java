package com.microservice.inventory.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "inventories")
@AllArgsConstructor
@NoArgsConstructor
public class Inventory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    private Integer quantity;

    @Column(name = "product_id")
    private Long productId;

}
