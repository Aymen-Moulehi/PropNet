package tn.esprit.propnetapp.features.image;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class ImageServiceImpl implements IImageService {

    ImageRepository imageRepository;


    @Override
    public Image uploadImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image loadImageDetailsById(Integer idImage) {
        return imageRepository.findImageByIdImage(idImage);
    }
}