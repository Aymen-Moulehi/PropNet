package tn.esprit.propnetapp.appuser;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.propnetapp.post.Post;

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
    @CrossOrigin
    public AppUser addAppUserS(@RequestBody AppUser appUser) {
        return appUserService.addAppUser(appUser);
    }

    @GetMapping("/user-post-withLocation")
    @CrossOrigin
    List<Map<String, Object>> findPostWithLocation() {
        return appUserService.findPostWithLocation();
    }

    @GetMapping("/user-by-region")
    @CrossOrigin
    public List<Map<String, Object>> getUsersCountByRegion() {
        return appUserService.getUsersByRegion();
    }

    @GetMapping("/countUser")
    @CrossOrigin
    public Integer countUsers() {
        return appUserService.countUsers();
    }

    @GetMapping("/users")
    @CrossOrigin
    public List<AppUser> getUsers(){
        return appUserRepository.getAllusers();}
    @DeleteMapping("/delete/{idAppUser}")
    @CrossOrigin
    public void deleteUser(@PathVariable("idAppUser") Integer idAppUser) {
        appUserService.deleteUser(idAppUser);
    }
    @PutMapping("/account/activate/{idAppUser}")
    @CrossOrigin
    public void activateAccount(@PathVariable("idAppUser")  Integer idAppUser) {
        appUserService.activateAccount(idAppUser);

    }
    @PutMapping("/account/deactivate/{idAppUser}")
    @CrossOrigin
    public void deactivateAccount(@PathVariable("idAppUser")  Integer idAppUser) {
        appUserService.deactivateAccount(idAppUser);
    }

    @GetMapping("/address/{address}")
    @CrossOrigin
    public List<AppUser> getUsersByAddress(@PathVariable String address) {
        return appUserService.getUsersByAddress(address);
    }




}
