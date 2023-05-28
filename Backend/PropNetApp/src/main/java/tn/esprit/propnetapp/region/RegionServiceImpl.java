package tn.esprit.propnetapp.region;

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
public class RegionServiceImpl implements IRegionService {

    RegionRepository regionRepository;

    @Override
    public Region addRegion(Region region) {
        return regionRepository.save(region);
    }
}