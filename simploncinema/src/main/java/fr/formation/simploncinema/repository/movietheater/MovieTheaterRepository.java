package fr.formation.simploncinema.repository.movietheater;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.simploncinema.domain.entities.movietheater.MovieTheater;

public interface MovieTheaterRepository extends JpaRepository<MovieTheater, Long> {

	 Optional<MovieTheater> findByMovietheatername(String movietheatername);

	boolean existsByMovietheatername(String value);


}
