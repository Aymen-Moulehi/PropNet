package tn.esprit.propnetapp.realestatellisting;

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
public class RealEstateListingServiceImpl implements IRealEstateListingService {

    RealEstateListingRepository realEstateListingRepository;

    @Override
    public RealEstateListing addRealEstateListing(RealEstateListing realEstateListing) {
        return realEstateListingRepository.save(realEstateListing);
    }
}