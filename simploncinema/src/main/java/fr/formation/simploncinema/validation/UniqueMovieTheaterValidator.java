package fr.formation.simploncinema.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.simploncinema.repository.movietheater.MovieTheaterRepository;

public class UniqueMovieTheaterValidator implements ConstraintValidator<UniqueMovieTheater, String> {
    private final MovieTheaterRepository movie;
    
    
    public UniqueMovieTheaterValidator(MovieTheaterRepository movie) {
	super();
	this.movie = movie;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	// TODO Auto-generated method stub
	if (value==null) {
	return true;
    }

    // MovieTheaterName dans la base de données => true => false
    return !movie.existsByMovietheatername(value);

    }
}
