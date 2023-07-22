package tn.esprit.propnetapp.city;


import java.util.List;

public interface ICityService {
    City addRegion(City city);
    List<City> retrieveAllRegions();
    City updateRegion(City city);
    City retrieveRegion(Integer idRegion);
    void deleteRegion(Integer idRegion);

    List<City> getCityBygovid(Integer idGovernorate);
}