package tn.esprit.propnetapp.appuser;

import org.apache.catalina.User;

import java.util.List;
import java.util.Map;

public interface IAppUserService {
    AppUser addAppUser(AppUser appUser);

    List<Map<String, Object>> findPostWithLocation();

    public List<Map<String, Object>> getUsersByRegion();
    public Integer countUsers();

    public List<AppUser> getAllusers();

    public void deleteUser(Integer idAppUser);

    public void activateAccount(Integer idAppUser);
    public void deactivateAccount(Integer idAppUser);

    List<AppUser> getUsersByAddress(String address);



}