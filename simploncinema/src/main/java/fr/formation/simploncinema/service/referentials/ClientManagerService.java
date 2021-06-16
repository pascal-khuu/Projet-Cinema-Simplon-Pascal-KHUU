package fr.formation.simploncinema.service.referentials;

import java.util.ArrayList;

import fr.formation.simploncinema.domain.dtos.referentials.ClientDTO;

public interface ClientManagerService {

	ArrayList<ClientDTO> getUserByLastname(String lastname);
    ClientDTO getUserById(long refclient);
    
    //ArrayList<ClientDTO> getUserByPasswordAndMail(String password, String mail);
    ClientDTO getUserByPasswordAndMail(String password, String mail);
    void createUser(ClientDTO dto);
    void deleteUser(long refclient);
    ArrayList<ClientDTO> findAllUsers();
	void updateUser(long refclient, ClientDTO dto);

}
