package tn.esprit.propnetapp.governorate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class GovernorateServiceImpl implements IGovernorateService {

    GovernorateRepository governorateRepository;

    @Override
    @CrossOrigin
    public Governorate addGovernorate(Governorate governorate) {
        return governorateRepository.save(governorate);
    }

    @Override
    @CrossOrigin
    public List<Governorate> retrieveAllGovernorates() {
        return governorateRepository.findAll();
    }

    @Override
    @CrossOrigin
    public Governorate updateGovernorate(Governorate governorate) {
        return governorateRepository.save(governorate);
    }

    @Override
    @CrossOrigin
    public Governorate retrieveGovernorate(Integer idGovernorate) {
        return governorateRepository.findById(idGovernorate).get();
    }

    @Override
    @CrossOrigin
    public void deleteGovernorate(Integer idGovernorate) {
        governorateRepository.deleteById(idGovernorate);
    }
}