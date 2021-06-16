package fr.formation.simploncinema.controllers.movietheater;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.simploncinema.domain.dtos.movietheater.MovieTheaterDTO;
import fr.formation.simploncinema.service.movietheater.MovieTheaterService;

@RestController
public class MovieTheaterController {

    private final MovieTheaterService service;

    public MovieTheaterController(MovieTheaterService service) {
	this.service = service;
    }

    @GetMapping("/movietheater/{id}/by-id")

    public Optional<MovieTheaterDTO> getMovieTheaterbyId(@PathVariable("id") Long id) {
	// service=null
	System.out.println(" call in controller");
	return service.getMovietheaterById(id);
    }

    @GetMapping("/movietheater/{movietheatername}")

    public Optional<MovieTheaterDTO> getMovietheaterByMovietheatername(
	    @PathVariable("movietheatername") String movietheatername) {
	// service=null
	System.out.println(" call in controller");
	return Optional.of(service.getMovietheaterByMovietheatername(movietheatername).get());
    }

    @GetMapping("/movietheaters")

    public List<MovieTheaterDTO> getMovieTheaters() {
	List<MovieTheaterDTO> movietheaters = service.findAllMovietheaters();
	return movietheaters;
    }

    @DeleteMapping("/movietheater/{id}/delete")

    public void deleteMovieTheater(@PathVariable("id") Long id) {
	service.deleteMovietheater(id);
    }

    @PostMapping("/movietheater/create")
    public void createMovieTheater(@Valid @RequestBody MovieTheaterDTO dto) {
	System.out.println(dto);
	service.createMovietheater(dto);
    }

    @PatchMapping("/movietheater/{id}/update")
    public void updateMovieTheater(@PathVariable("id") Long id, @RequestBody MovieTheaterDTO dto) {
	System.out.println(dto);
	service.updateMovietheater(id, dto);
    }
}
