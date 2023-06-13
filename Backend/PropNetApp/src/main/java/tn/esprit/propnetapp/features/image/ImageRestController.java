package tn.esprit.propnetapp.features.image;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/image")
public class ImageRestController {
    IImageService imageService;

    @PostMapping("/upload")
    @CrossOrigin
    public String uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        Image image = imageService.uploadImage(
                Image.builder()
                .imageName(file.getOriginalFilename())
                .imageType(file.getContentType()).imageCreationDate(new Date())
                .imageContent(file.getBytes()).build()
                );
        return image.getIdImage().toString();
    }

    @GetMapping(path = {"/get/info/{id}"})
    public Image getImageDetails(@PathVariable("id") Integer imageId) {
        return imageService.loadImageDetailsById(imageId);
    }

    @GetMapping(path = {"/get/{id}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer imageId) {

        Image dbImage = imageService.loadImageDetailsById(imageId);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.getImageType()))
                .body(dbImage.getImageContent());
    }
}
