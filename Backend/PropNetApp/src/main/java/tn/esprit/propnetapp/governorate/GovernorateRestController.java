package tn.esprit.propnetapp.governorate;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/governorate")
public class GovernorateRestController {
    IGovernorateService governorateService;

    @PostMapping("/add-governorate")
    public Governorate addGovernorateS(@RequestBody Governorate governorate) {
        return governorateService.addGovernorate(governorate);
    }
}
