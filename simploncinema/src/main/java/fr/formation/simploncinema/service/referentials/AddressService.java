package fr.formation.simploncinema.service.referentials;

import java.util.ArrayList;


import fr.formation.simploncinema.domain.dtos.referentials.*;

public interface AddressService {

	ArrayList<AddressDTO> getAddressByPostalCode(String postalcode);
	ArrayList<AddressDTO> getAddressByCity(String cityname);

	AddressDTO getAddressById(long id);

    void createAddress(AddressDTO dto);
    void deleteAddress(long id);
    ArrayList<AddressDTO> findAllAddresses();
	void updateAddress(long id, AddressDTO addressDTO);

}
