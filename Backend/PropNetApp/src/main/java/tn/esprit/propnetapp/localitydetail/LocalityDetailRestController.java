package tn.esprit.propnetapp.localitydetail;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/localityDetail")
public class LocalityDetailRestController {
    ILocalityDetailService localityDetailService;

    @PostMapping("/add-localityDetail")
    public LocalityDetail addLocalityDetail(@RequestBody LocalityDetail localityDetail) {
        return localityDetailService.addLocalityDetail(localityDetail);
    }
    @GetMapping("/retrieve-all-localityDetails")
    public List<LocalityDetail> getAllLocalityDetails() {
        return localityDetailService.retrieveAllLocalityDetails();
    }
    @GetMapping("/retrieve-localityDetail/{localityDetail-id}")
    public LocalityDetail retrieveLocalityDetail(@PathVariable("localityDetail-id") Long localityDetailId) {
        return localityDetailService.retrieveLocalityDetail(localityDetailId);
    }
    @DeleteMapping("/remove-localityDetail/{localityDetail-id}")
    public void removeLocalityDetail(@PathVariable("localityDetail-id") Long localityDetailId) {
        localityDetailService.deleteLocalityDetail(localityDetailId);
    }
    @PutMapping("/update-localityDetail")
    public LocalityDetail updateLocalityDetail(@RequestBody LocalityDetail localityDetail) {
        return localityDetailService.updateLocalityDetail(localityDetail);
    }
}
