package fr.formation.simploncinema.repository.referentials;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.simploncinema.domain.entities.referentials.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    ArrayList<Client> findByLastname(String lastname);
    Optional<Client> findByPasswordAndMail(String password, String mail);

}
