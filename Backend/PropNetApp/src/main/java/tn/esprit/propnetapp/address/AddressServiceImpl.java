package tn.esprit.propnetapp.address;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class AddressServiceImpl implements IAddressService {

    AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> retrieveAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(Address e) {return addressRepository.save(e);
    }

    @Override
    public Address retrieveAddress(Long idAddress) {
        return addressRepository.findById(idAddress).get();
    }

    @Override
    public void deleteAddress(Long idAddress) {
        addressRepository.deleteById(idAddress);
    }
}