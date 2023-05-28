package tn.esprit.propnetapp.governorate;

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
public class GovernorateServiceImpl implements IGovernorateService {

    GovernorateRepository governorateRepository;

    @Override
    public Governorate addGovernorate(Governorate governorate) {
        return governorateRepository.save(governorate);
    }
}