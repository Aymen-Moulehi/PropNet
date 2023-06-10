package tn.esprit.propnetapp.region;


import java.util.List;

public interface IRegionService {
    Region addRegion(Region region);
    List<Region> retrieveAllRegions();
    Region updateRegion(Region region);
    Region retrieveRegion(Long idRegion);
    void deleteRegion(Long idRegion);
}