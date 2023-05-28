package tn.esprit.propnetapp.localitydetail;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/localityDetail")
public class LocalityDetailRestController {
    ILocalityDetailService localityDetailService;

    @PostMapping("/add-localityDetail")
    public LocalityDetail addLocalityDetailS(@RequestBody LocalityDetail localityDetail) {
        return localityDetailService.addLocalityDetail(localityDetail);
    }
}
