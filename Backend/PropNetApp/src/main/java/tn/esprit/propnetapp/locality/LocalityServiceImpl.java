package tn.esprit.propnetapp.locality;

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
public class LocalityServiceImpl implements ILocalityService {

    LocalityRepository localityRepository;

    @Override
    public Locality addLocality(Locality locality) {
        return localityRepository.save(locality);
    }
}