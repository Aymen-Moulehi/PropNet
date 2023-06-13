package tn.esprit.propnetapp.features.image;

public interface IImageService {
    Image uploadImage(Image image);
    Image loadImageDetailsById(Integer idImage);
}