package project.photogallery.services.abstracts;

import org.springframework.web.multipart.MultipartFile;
import project.photogallery.entities.Image;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    public byte[] getOneImage(Long id);

    public Image saveImage(MultipartFile multipartFile) throws IOException;

    public List<Image> findAll();
}
