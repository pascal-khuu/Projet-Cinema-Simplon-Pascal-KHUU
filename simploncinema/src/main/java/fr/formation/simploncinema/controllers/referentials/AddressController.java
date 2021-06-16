package fr.formation.simploncinema.controllers.referentials;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.simploncinema.domain.dtos.referentials.AddressDTO;
import fr.formation.simploncinema.service.referentials.AddressService;

@RestController
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
	this.service = service;
    }

    @GetMapping("/address/{id}/by-id")

    public AddressDTO getAddressById(@PathVariable("id") Long id) {
	// service=null
	System.out.println(" call in controller");
	return service.getAddressById(id);
    }

    @GetMapping("/address/{postalcode}")

    public ArrayList<AddressDTO> getAddressByPostalCode(@PathVariable("postalcode") String postalcode) {
	// service=null
	System.out.println(" call in controller");
	return service.getAddressByPostalCode(postalcode);
    }

    @GetMapping("/addresses")

    public ArrayList<AddressDTO> getMovieTheaters() {
	ArrayList<AddressDTO> addresses = service.findAllAddresses();
	return addresses;
    }

    @PostMapping("/address/{id}/delete")

    public void deleteAddress(@PathVariable("id") Long id) {
	service.deleteAddress(id);
    }

    @PostMapping("/address/create")
    public void createMovieTheater(@Valid @RequestBody AddressDTO dto) {
	System.out.println(dto);
	service.createAddress(dto);
    }

    @PatchMapping("/address/{id}/update")
    public void updateAddress(@PathVariable("id") Long id, @Valid @RequestBody AddressDTO dto) {
	System.out.println(dto);
	service.updateAddress(id, dto);
    }
}
