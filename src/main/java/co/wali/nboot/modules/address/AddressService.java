package co.wali.nboot.modules.address;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressService {

    private final AddressRepository addressRepository;


    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> allAddress(){
        return addressRepository.findAll();
    }

    public void addAdr(Address address){
        addressRepository.saveAndFlush(address);
    }


}
