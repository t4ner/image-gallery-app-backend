package project.photogallery.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.photogallery.entities.Image;
import project.photogallery.services.abstracts.ImageService;

import java.util.List;

@RequestMapping("/images")
@RestController
@AllArgsConstructor
public class ImagesController {

   private ImageService imageService;
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping(value = "/add" ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<String> saveImage(@RequestParam("image") MultipartFile file) {
        try {
            imageService.saveImage(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(file.getOriginalFilename());
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("getById/{id}")
    public HttpEntity<byte[]> getImage(@PathVariable Long id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(imageService.getOneImage(id), httpHeaders, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getAll")
    public List<Image> getDocument() {
        return imageService.findAll();
    }


}