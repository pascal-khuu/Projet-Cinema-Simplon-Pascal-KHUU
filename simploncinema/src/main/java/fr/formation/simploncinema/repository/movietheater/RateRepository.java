package fr.formation.simploncinema.repository.movietheater;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.simploncinema.domain.entities.movietheater.Rate;

public interface RateRepository extends JpaRepository<Rate, Long> {
    Optional<Rate> findByType(String type);
}
