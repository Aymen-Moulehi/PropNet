package tn.esprit.propnetapp.address;

import java.util.List;

public interface IAddressService {
    Address addAddress(Address address);
    List<Address> retrieveAllAddress();
    Address updateAddress(Address e);
    Address retrieveAddress(Long idAddress);
    void deleteAddress(Long idAddress);
}