package tn.esprit.propnetapp.governorate;


import java.util.List;

public interface IGovernorateService {
    Governorate addGovernorate(Governorate governorate);
    List<Governorate> retrieveAllGovernorates();
    Governorate updateGovernorate(Governorate governorate);
    Governorate retrieveGovernorate(Integer idGovernorate);
    void deleteGovernorate(Integer idGovernorate);
}