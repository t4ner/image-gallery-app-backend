package project.photogallery.services.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.photogallery.entities.Image;
import project.photogallery.repository.ImageRepository;
import project.photogallery.services.abstracts.ImageService;

import java.io.IOException;
import java.util.List;
@Service
@AllArgsConstructor
public class ImageManager implements ImageService {
    private ImageRepository imageRepository;

    @Override
    public byte[] getOneImage(Long id) {
        imageRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("image with " + id + " doesn't exist"));
        return imageRepository.findById(id).get().getFile();
    }
    @Override
    public Image saveImage(MultipartFile multipartFile) throws IOException {
        Image image = new Image(
                multipartFile.getOriginalFilename(),
                multipartFile.getContentType(),
                multipartFile.getBytes()
        );

        return imageRepository.save(image);	}

    @Override
    public List<Image> findAll() {
        return (List<Image>) imageRepository.findAll();
    }
}
