package tn.esprit.propnetapp.appuser;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/appUser")
public class AppUserRestController {
    IAppUserService appUserService;

    @PostMapping("/add-appUser")
    public AppUser addAppUserS(@RequestBody AppUser appUser) {
        return appUserService.addAppUser(appUser);
    }
}
