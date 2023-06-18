package tn.esprit.propnetapp.appuser;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/appUser")
@CrossOrigin(origins = "http://localhost:4200")
public class AppUserRestController {
    IAppUserService appUserService;
    AppUserRepository appUserRepository;


    @PostMapping("/add-appUser")
    public AppUser addAppUserS(@RequestBody AppUser appUser) {
        return appUserService.addAppUser(appUser);
    }

    @GetMapping("/user-post-withLocation")
    List<Map<String, Object>> findPostWithLocation() {
        return appUserService.findPostWithLocation();
    }

}
