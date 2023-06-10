package tn.esprit.propnetapp.address;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressRestController {
    IAddressService addressService;


    @PostMapping("/add-address")
    public Address addAddress(@RequestBody Address address) {

        return addressService.addAddress(address);
    }
    @GetMapping("/retrieve-all-address")
    public List<Address> getAllAddress() {
        return addressService.retrieveAllAddress();
    }
    @GetMapping("/retrieve-address/{address-id}")
    public Address retrieveAddress(@PathVariable("address-id") Long addressId) {
        return addressService.retrieveAddress(addressId);
    }
    @DeleteMapping("/remove-address/{address-id}")
    public void removeAddress(@PathVariable("address-id") Long addressId) {

        addressService.deleteAddress(addressId);
    }
    @PutMapping("/update-address")
    public Address updateAddress(@RequestBody Address address) {
        return addressService.updateAddress(address);
    }
}
