package tn.esprit.propnetapp.region;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class RegionServiceImpl implements IRegionService {

    RegionRepository regionRepository;

    @Override
    public Region addRegion(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public List<Region> retrieveAllRegions() {
        return regionRepository.findAll();
    }

    @Override
    public Region updateRegion(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public Region retrieveRegion(Long idRegion) {
        return regionRepository.findById(idRegion).get();
    }

    @Override
    public void deleteRegion(Long idRegion) {
        regionRepository.deleteById(idRegion);

    }
}