package tn.esprit.propnetapp.city;

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
public class CityServiceImpl implements ICityService {

    CityRepository cityRepository;

    @Override
    public City addRegion(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> retrieveAllRegions() {
        return cityRepository.findAll();
    }

    @Override
    public City updateRegion(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City retrieveRegion(Integer idRegion) {
        return cityRepository.findById(idRegion).get();
    }

    @Override
    public void deleteRegion(Integer idRegion) {
        cityRepository.deleteById(idRegion);

    }

    @Override
    public List<City> getCityBygovid(Integer idGovernorate) {
        return cityRepository.getCityByGovernorateIdGovernorate(idGovernorate);
    }

}