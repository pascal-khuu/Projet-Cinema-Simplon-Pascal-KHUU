package fr.formation.simploncinema.service.referentials;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.simploncinema.domain.dtos.referentials.ClientDTO;
import fr.formation.simploncinema.domain.entities.referentials.Client;
import fr.formation.simploncinema.repository.referentials.ClientRepository;
import fr.formation.simploncinema.utilities.*;

@Service
public class ClientManagerServiceImpl extends UtilitiesDataManagerImpl implements ClientManagerService {

	private final ClientRepository repository;

	public ClientManagerServiceImpl(ClientRepository repository) {
		this.repository = repository;
	}

	@Override
	public ArrayList<ClientDTO> getUserByLastname(String lastname) {
		ArrayList<Client> users = repository.findByLastname(lastname);
		ArrayList<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();
		for (int i = 0; i < users.size(); i++) {
			ClientDTO userDTO = getClientDTO(users.get(i),users.get(i).getAddress());
			clientsDTO.add(userDTO);
		}
		return clientsDTO;
	}
	
	@Override
	public void createUser(ClientDTO dto) {
		Client user = getClient(dto, dto.getAddress());
		List<Client> clients = repository.findAll();
		
		//contrainte
		if (clients.size() > 0) {
			user.setRefclient(clients.get(clients.size() - 1).getId() + 1);
		}else {
			user.setRefclient(1);
		}

		repository.save(user);

	}

	@Override
	public void updateUser(long refclient, ClientDTO dto) {
		Client user = repository.findById(refclient).get();

		user=getClient(dto, dto.getAddress());

		repository.save(user);

	}

	@Override
	public ClientDTO getUserById(long refclient) {
		Client user = repository.findById(refclient).get();
		ClientDTO userDTO = getClientDTO(user, user.getAddress());
		
		return userDTO;
	}

	@Override
	public void deleteUser(long refclient) {
		repository.deleteById(refclient);

	}

	@Override
	public ArrayList<ClientDTO> findAllUsers() {
		List<Client> clients = repository.findAll();
		ArrayList<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();
		for (int i = 0; i < clients.size(); i++) {
			ClientDTO clientDTO = getClientDTO(clients.get(i), clients.get(i).getAddress());
			clientsDTO.add(clientDTO);
			System.out.println(clientDTO.toString());
		}
		return clientsDTO;
	}

	@Override
	public ClientDTO getUserByPasswordAndMail(String password, String mail) {
		Client user = repository.findByPasswordAndMail(password, mail).get();
		ClientDTO clientDTO = getClientDTO(user, user.getAddress());
		return clientDTO;

	}


}
