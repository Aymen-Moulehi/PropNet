package tn.esprit.propnetapp.appuser;

public interface IAppUserService {

    AppUser registerUser(AppUser appUser);

    String login(String email, String password);
}