package tn.esprit.propnetapp.locality;


import java.util.List;

public interface ILocalityService {
    Locality addLocality(Locality locality);
    List<Locality> retrieveAllLocalities();
    Locality updateLocality(Locality locality);
    Locality retrieveLocality(Long idLocality);
    void deleteLocality(Long idLocality);
}