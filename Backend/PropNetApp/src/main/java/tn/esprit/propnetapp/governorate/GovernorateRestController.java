package tn.esprit.propnetapp.governorate;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/governorate")
@CrossOrigin(origins = "http://localhost:4200")
public class GovernorateRestController {
    IGovernorateService governorateService;

    @PostMapping("/add-governorate")
    public Governorate addGovernorate(@RequestBody Governorate governorate) {
        return governorateService.addGovernorate(governorate);
    }


    @GetMapping("/retrieve-all-governorates")
    public List<Governorate> getAllGovernorates() {
        return governorateService.retrieveAllGovernorates();
    }
    @GetMapping("/retrieve-governorate/{governorate-id}")
    public Governorate retrieveGovernorate(@PathVariable("governorate-id") Integer governorateId) {
        return governorateService.retrieveGovernorate(governorateId);
    }
    @DeleteMapping("/remove-governorate/{governorate-id}")
    public void removeGovernorate(@PathVariable("governorate-id") Integer governorateId) {
        governorateService.deleteGovernorate(governorateId);
    }
    @PutMapping("/update-governorate")
    public Governorate updateGovernorate(@RequestBody Governorate governorate) {
        return governorateService.updateGovernorate(governorate);
    }
}
