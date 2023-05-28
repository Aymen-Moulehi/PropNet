package tn.esprit.propnetapp.address;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressRestController {
    IAddressService addressService;

    @PostMapping("/add-address")
    public Address addAddressS(@RequestBody Address address) {
        return addressService.addAddress(address);
    }
}
