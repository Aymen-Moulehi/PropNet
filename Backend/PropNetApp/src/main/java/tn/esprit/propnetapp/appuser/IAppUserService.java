package tn.esprit.propnetapp.appuser;

import java.util.List;
import java.util.Map;

public interface IAppUserService {

    AppUser addAppUser(AppUser appUser);

    List<Map<String, Object>> findPostWithLocation();
}