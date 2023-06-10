package tn.esprit.propnetapp.localitydetail;


import java.util.List;

public interface ILocalityDetailService {
    LocalityDetail addLocalityDetail(LocalityDetail localityDetail);
    List<LocalityDetail> retrieveAllLocalityDetails();
    LocalityDetail updateLocalityDetail(LocalityDetail localityDetail);
    LocalityDetail retrieveLocalityDetail(Long idLocalityDetail);
    void deleteLocalityDetail(Long idLocalityDetail);
}