package tn.esprit.propnetapp.governorate;


import java.util.List;

public interface IGovernorateService {
    Governorate addGovernorate(Governorate governorate);
    List<Governorate> retrieveAllGovernorates();
    Governorate updateGovernorate(Governorate governorate);
    Governorate retrieveGovernorate(Long idGovernorate);
    void deleteGovernorate(Long idGovernorate);
}