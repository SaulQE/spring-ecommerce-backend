package com.microservice.image.controller;

import com.microservice.image.entities.Image;
import com.microservice.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController
{
    @Autowired
    private ImageService imageService;

    @PostMapping("/create")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Image image = imageService.uploadImage(file);
            return new ResponseEntity<>(image, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{imageId}")
    public ResponseEntity<?> updateImage(@PathVariable Long imageId, @RequestParam("file") MultipartFile file)
    {
        try {
            Image image = imageService.updateImage(imageId, file);
            return new ResponseEntity<>(image, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{imageId}")
    public ResponseEntity<?> deleteImage(@PathVariable Long imageId) {
        try {
            Image image = imageService.findById(imageId);
            if (image != null) {
                imageService.deleteImage(image);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllImages() {
        try {
            List<Image> images = imageService.findAll();
            return new ResponseEntity<>(images, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/{imageId}")
    public ResponseEntity<?> findImageById(@PathVariable Long imageId) {
        try {
            Image image = imageService.findById(imageId);
            if (image != null) {
                return new ResponseEntity<>(image, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
