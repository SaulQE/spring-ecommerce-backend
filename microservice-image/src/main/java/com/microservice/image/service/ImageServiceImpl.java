package com.microservice.image.service;

import com.microservice.image.entities.Image;
import com.microservice.image.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService
{

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public Image uploadImage(MultipartFile file) throws Exception
    {
        Map uploadResult = cloudinaryService.upload(file);
        String imageUrl = (String) uploadResult.get("url");
        String imagePublicId = (String) uploadResult.get("public_id");
        Image image = new Image(file.getOriginalFilename(), imageUrl, imagePublicId);

        return imageRepository.save(image);
    }

    @Override
    public void deleteImage(Image image) throws Exception
    {
        cloudinaryService.delete(image.getPublicId());
        imageRepository.delete(image);
    }

    @Override
    public Image findByPublicId(String publicId) {
        return imageRepository.findByPublicId(publicId);
    }
}
