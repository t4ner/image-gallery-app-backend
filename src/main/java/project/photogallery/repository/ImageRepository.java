package project.photogallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.photogallery.entities.Image;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
