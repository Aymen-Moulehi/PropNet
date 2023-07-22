package tn.esprit.propnetapp.city;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    public List<City> getCityByGovernorateIdGovernorate(Integer idGovernorate);

}
