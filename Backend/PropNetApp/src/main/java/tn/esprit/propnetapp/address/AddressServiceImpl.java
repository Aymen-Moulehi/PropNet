package tn.esprit.propnetapp.address;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
}