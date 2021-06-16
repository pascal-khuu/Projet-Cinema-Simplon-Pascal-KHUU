package fr.formation.simploncinema.service.movietheater;

import java.util.List;
import java.util.Optional;

import fr.formation.simploncinema.domain.dtos.movietheater.MovieTheaterDTO;

public interface MovieTheaterService {

	Optional<MovieTheaterDTO> getMovietheaterByMovietheatername(String movietheatername);
	Optional<MovieTheaterDTO> getMovietheaterById(long id);
    
    void createMovietheater(MovieTheaterDTO dto);
    void deleteMovietheater(long id);
    List<MovieTheaterDTO> findAllMovietheaters();
	void updateMovietheater(long id, MovieTheaterDTO dto);
	
}
