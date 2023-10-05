package co.wali.nboot.modules.address;


import co.wali.nboot.modules.student.Student;
import co.wali.nboot.modules.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/addr")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping("findAll")
    public List<Address> allData(){
        return addressService.allAddress();
    }

    @PostMapping
    public void addAddr(@RequestBody Address address){
        addressService.addAdr(address);
    }
}
