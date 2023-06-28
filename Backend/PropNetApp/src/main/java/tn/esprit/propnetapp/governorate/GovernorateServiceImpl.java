package tn.esprit.propnetapp.governorate;

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
public class GovernorateServiceImpl implements IGovernorateService {

    GovernorateRepository governorateRepository;

    @Override
    public Governorate addGovernorate(Governorate governorate) {
        return governorateRepository.save(governorate);
    }

    @Override
    public List<Governorate> retrieveAllGovernorates() {
        return governorateRepository.findAll();
    }

    @Override
    public Governorate updateGovernorate(Governorate governorate) {
        return governorateRepository.save(governorate);
    }

    @Override
    public Governorate retrieveGovernorate(Integer idGovernorate) {
        return governorateRepository.findById(idGovernorate).get();
    }

    @Override
    public void deleteGovernorate(Integer idGovernorate) {
        governorateRepository.deleteById(idGovernorate);
    }
}