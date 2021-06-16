package fr.formation.simploncinema.validation;

import java.time.LocalTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompareClockNowValidator implements ConstraintValidator<CompareClockNow, LocalTime> {

    @Override
    public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
	if (value == null) {
	    return false;
	}

	return (value.isAfter(value.now()));
    }

}
