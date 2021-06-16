package fr.formation.simploncinema.controllers.referentials;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.simploncinema.domain.dtos.referentials.ClientDTO;
import fr.formation.simploncinema.service.referentials.ClientManagerService;

@RestController
public class UserController {

    private final ClientManagerService service;

    public UserController(ClientManagerService service) {
	this.service = service;
    }

    @GetMapping("/user/{id}/by-id")

    public ClientDTO getUserbyId(@PathVariable("id") Long id) {
	// service=null
	System.out.println(" call in controller");
	return service.getUserById(id);
    }

    @GetMapping("/user/{password}/{mail}")

    public ClientDTO getUserByMailAndPassword(@PathVariable("mail") String mail,
	    @PathVariable("password") String password) {
	// service=null
	System.out.println(" call in controller");
	return service.getUserByPasswordAndMail(password, mail);
    }

    @GetMapping("/user/{lastname}/by-lastname")

    public ArrayList<ClientDTO> getUserbyName(@PathVariable("lastname") String lastname) {

	return service.getUserByLastname(lastname);
    }

    @GetMapping("/users")

    public ArrayList<ClientDTO> getUsers() {
	ArrayList<ClientDTO> clients = service.findAllUsers();
	return clients;
    }

    @DeleteMapping("/user/{id}/delete")

    public void deleteUser(@PathVariable("id") Long id) {
	service.deleteUser(id);
    }

    @PostMapping("/user/create")
    public void createUser(@Valid @RequestBody ClientDTO dto) {
	System.out.println(dto);
	service.createUser(dto);
    }

    @PatchMapping("/user/{id}/update")
    public void updateUser(@PathVariable("id") Long id, @Valid @RequestBody ClientDTO dto) {
	System.out.println(dto);
	service.updateUser(id, dto);
    }
}
