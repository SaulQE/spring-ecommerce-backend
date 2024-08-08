package com.microservice.image.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryService
{
    Map upload(MultipartFile multipartFile) throws Exception;
    Map delete(String publicId) throws Exception;
}
