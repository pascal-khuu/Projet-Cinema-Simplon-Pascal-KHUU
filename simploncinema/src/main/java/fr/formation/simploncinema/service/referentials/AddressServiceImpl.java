package fr.formation.simploncinema.service.referentials;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.simploncinema.domain.dtos.referentials.AddressDTO;
import fr.formation.simploncinema.domain.dtos.referentials.CityDTO;
import fr.formation.simploncinema.domain.entities.referentials.Address;
import fr.formation.simploncinema.repository.referentials.AddressRepository;
import fr.formation.simploncinema.utilities.*;

@Service
public class AddressServiceImpl extends UtilitiesDataManagerImpl implements AddressService {

	private final AddressRepository repository;

	public AddressServiceImpl(AddressRepository repository) {
		this.repository = repository;
	}



	@Override
	public ArrayList<AddressDTO> getAddressByPostalCode(String postalcode) {
		List<Address> addresses = repository.findByPostalcode(postalcode);
		ArrayList<AddressDTO> addressesDTO = getAddressesDTO(addresses);

		return addressesDTO;
	}

	@Override
	public ArrayList<AddressDTO> getAddressByCity(String cityname) {
		ArrayList<AddressDTO> addressesDTO = findAllAddresses();
		
		ArrayList<AddressDTO> addressesBycity=new ArrayList<AddressDTO>();
		for (int i = 0; i < addressesDTO.size(); i++) {
			CityDTO cityDTO=addressesDTO.get(i).getCity();
			if(cityDTO.getCityname().equals(cityname)) {
				addressesBycity.add(addressesDTO.get(i));
				
			}
		}

		return addressesBycity;
	}

	@Override
	public AddressDTO getAddressById(long id) {
		Address address = repository.findById(id).get();
		AddressDTO dto=getAddressDTO(address,address.getCity());
		return dto;
		
	}

	@Override
	public void createAddress(AddressDTO dto) {

		Address address = getAddress(dto,dto.getCity());
		repository.save(address);

	}

	@Override
	public void deleteAddress(long id) {
		repository.deleteById(id);

	}

	@Override
	public void updateAddress(long id, AddressDTO dto) {
		Address address = repository.findById(id).get();
		address = getAddress(dto,dto.getCity());
		repository.save(address);
	}

	@Override
	public ArrayList<AddressDTO> findAllAddresses() {
		List<Address> addresses = repository.findAll();
		ArrayList<AddressDTO> addressesDTO = getAddressesDTO(addresses);
		return addressesDTO;
	}
}
