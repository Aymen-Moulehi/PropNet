package tn.esprit.propnetapp.features.image;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    Image findImageByIdImage(Integer imageId);
}
