package fr.formation.simploncinema.repository.referentials;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.simploncinema.domain.entities.referentials.*;

public interface AddressRepository extends JpaRepository<Address, Long> {

    ArrayList<Address> findByPostalcode(String postalcode);

}
