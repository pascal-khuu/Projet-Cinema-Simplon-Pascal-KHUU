package fr.formation.simploncinema.repository.movietheater;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.simploncinema.domain.entities.movietheater.MeansOfPayment;

public interface MeansOfPaymentRepository extends JpaRepository<MeansOfPayment, Long> {

    Optional<MeansOfPayment> findByName(String name);

}
