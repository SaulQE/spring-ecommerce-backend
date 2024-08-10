package com.microservice.image.service;

import com.microservice.image.entities.Image;
import com.microservice.image.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    @Transactional
    public Image uploadImage(MultipartFile file, Long productId) throws Exception {
        Map uploadResult = cloudinaryService.upload(file);
        String imageUrl = (String) uploadResult.get("url");
        String imagePublicId = (String) uploadResult.get("public_id");
        Image image = new Image(file.getOriginalFilename(), imageUrl, imagePublicId);
        image.setProductId(productId);

        return imageRepository.save(image);
    }

    @Override
    @Transactional
    public void deleteImage(Image image) throws Exception {
        cloudinaryService.delete(image.getPublicId());
        imageRepository.delete(image);
    }

    @Override
    @Transactional(readOnly = true)
    public Image findById(Long imageId) {
        return imageRepository.findById(imageId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    @Transactional
    public Image updateImage(Long imageId, MultipartFile file, Long productId) throws Exception {
        Image imageDb = imageRepository.findById(imageId).orElse(null);

        if (imageDb == null) {
            throw new Exception("La imagen con ID " + imageId + " no fue encontrada.");
        }

        // Si se proporciona un nuevo archivo, actualiza la imagen en Cloudinary
        if (file != null && !file.isEmpty()) {
            cloudinaryService.delete(imageDb.getPublicId());
            Map uploadResult = cloudinaryService.upload(file);

            imageDb.setImageUrl((String) uploadResult.get("url"));
            imageDb.setPublicId((String) uploadResult.get("public_id"));
            imageDb.setName(file.getOriginalFilename());
        }

        if (productId != null) {
            imageDb.setProductId(productId);
        }

        return imageRepository.save(imageDb);
    }
}
