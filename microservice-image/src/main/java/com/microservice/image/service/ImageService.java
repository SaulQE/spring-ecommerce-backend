package com.microservice.image.service;

import com.microservice.image.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService
{
    Image uploadImage(MultipartFile file) throws Exception;
    void deleteImage(Image image) throws Exception;
    Image updateImage(Long imageId, MultipartFile file) throws Exception;
    Image findById(Long imageId);
    List<Image> findAll();
}
