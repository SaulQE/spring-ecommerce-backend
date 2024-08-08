package com.microservice.image.service;

import com.microservice.image.entities.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService
{
    Image uploadImage(MultipartFile file) throws Exception;
    void deleteImage(Image image) throws Exception;
    Image findByPublicId(String publicId);
}
