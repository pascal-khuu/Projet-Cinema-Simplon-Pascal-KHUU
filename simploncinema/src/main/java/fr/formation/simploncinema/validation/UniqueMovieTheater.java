package fr.formation.simploncinema.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy= {UniqueMovieTheaterValidator.class})
public @interface UniqueMovieTheater {
    String message() default "the movie is not unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
