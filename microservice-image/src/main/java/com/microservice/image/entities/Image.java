package com.microservice.image.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "images")
@AllArgsConstructor
@NoArgsConstructor
public class Image
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String name;
    private String imageUrl;
    private String publicId;
    private Long productId;

    public Image(String name, String imageUrl, String publicId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.publicId = publicId;
    }
}
