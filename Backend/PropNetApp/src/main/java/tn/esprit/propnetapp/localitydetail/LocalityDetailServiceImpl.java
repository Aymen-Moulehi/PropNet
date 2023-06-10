package tn.esprit.propnetapp.localitydetail;

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
public class LocalityDetailServiceImpl implements ILocalityDetailService {

    LocalityDetailRepository localityDetailRepository;

    @Override
    public LocalityDetail addLocalityDetail(LocalityDetail localityDetail) {
        return localityDetailRepository.save(localityDetail);
    }

    @Override
    public List<LocalityDetail> retrieveAllLocalityDetails() {
        return localityDetailRepository.findAll();
    }

    @Override
    public LocalityDetail updateLocalityDetail(LocalityDetail localityDetail) {
        return localityDetailRepository.save(localityDetail);
    }

    @Override
    public LocalityDetail retrieveLocalityDetail(Long idLocalityDetail) {
        return localityDetailRepository.findById(idLocalityDetail).get();
    }

    @Override
    public void deleteLocalityDetail(Long idLocalityDetail) {
        localityDetailRepository.deleteById(idLocalityDetail);
    }
}