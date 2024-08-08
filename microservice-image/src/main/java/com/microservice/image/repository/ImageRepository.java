package com.microservice.image.repository;

import com.microservice.image.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>
{
    Image findByPublicId(String publicId);
}
