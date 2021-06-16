package fr.formation.simploncinema.controllers.movietheater;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import fr.formation.simploncinema.domain.dtos.booking.ProjectionBookingDTO;
import fr.formation.simploncinema.domain.dtos.movietheater.ProjectionDTO;
import fr.formation.simploncinema.service.booking.ProjectionManagerService;

@RestController
public class ProjectionManagerController {

    private final ProjectionManagerService service;

    public ProjectionManagerController(ProjectionManagerService service) {
	this.service = service;
    }

    @GetMapping("/projectionbooking/{id}/by-id")

    public Optional<ProjectionBookingDTO> getProjectionBookingById(@PathVariable("id") Long refProjectionbooking) {
	// service=null
	System.out.println(" call in controller");
	return service.getProjectionBookingById(refProjectionbooking);
    }

    @GetMapping("/projection/{id}/by-id")

    public Optional<ProjectionDTO> getProjectionById(@PathVariable("id") Long refProjection) {
	// service=null
	System.out.println(" call in controller");
	return service.getProjectionById(refProjection);
    }

    @GetMapping("/projections/{movietheatername}/by-movietheatername")

    public List<ProjectionDTO> getProjectionByMovieTheater(@PathVariable("movietheatername") String movietheatername) {
	// service=null
	System.out.println(" call in controller");
	return service.getProjectionByMovieTheater(movietheatername);
    }

    @GetMapping("/projections/{projectiondate}/by-projectiondate")

    public List<ProjectionDTO> getProjectionByProjectiondate(@PathVariable("projectiondate") String projectiondate)
	    throws ParseException {
	// service=null
	System.out.println(" call in controller");

	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	Date parsedDateProjectionDate = formatter.parse(projectiondate);

	return service.getProjectionByProjectiondate(parsedDateProjectionDate);
    }

    @GetMapping("/projections/{movietheatername}/{projectiondate}/{moviename}/by-movietheatername-projectiondate-moviename")

    public List<ProjectionDTO> getProjectionByMovieTheaterAndProjectiondateAndMoviename(
	    @PathVariable("projectiondate") String projectiondate,
	    @PathVariable("movietheatername") String movietheatername, @PathVariable("moviename") String moviename)
	    throws ParseException {
	// service=null
	System.out.println(" call in controller");
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	Date parsedDateProjectionDate = formatter.parse(projectiondate);
	return service.getProjectionByMovieTheaterAndProjectiondateAndMoviename(parsedDateProjectionDate,
		movietheatername, moviename);
    }

    @GetMapping("/projections/{movietheatername}/{projectiondate}/by-movietheatername-projectiondate")

    public List<ProjectionDTO> getProjectionByMovieTheaterProjectiondate(
	    @PathVariable("projectiondate") String projectiondate,
	    @PathVariable("movietheatername") String movietheatername) throws ParseException {
	// service=null
	System.out.println(" call in controller");
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	Date parsedDateProjectionDate = formatter.parse(projectiondate);
	return service.getProjectionByMovieTheaterProjectiondate(parsedDateProjectionDate, movietheatername);
    }

    @GetMapping("/projections/{movietheatername}/{moviename}/by-movietheatername-moviename")

    public List<ProjectionDTO> getProjectionByMovieAndMovieTheater(
	    @PathVariable("movietheatername") String movietheatername, @PathVariable("moviename") String moviename) {
	// service=null
	System.out.println(" call in controller");
	return service.getProjectionByMovieAndMovieTheater(movietheatername, moviename);
    }

    @GetMapping("/projections")

    public List<ProjectionDTO> findAllProjections() {
	List<ProjectionDTO> Projections = service.findAllProjections();
	return Projections;
    }

    @DeleteMapping("/projectionbooking/{id}/cancel")

    public void deleteProjectionBooking(@PathVariable("id") Long refProjectionbooking) {
	service.deleteProjectionBooking(refProjectionbooking);
    }

    @PostMapping("/projectionbooking/create")
    public void createProjectionBooking(@Valid @RequestBody ProjectionBookingDTO dto) {
	System.out.println(dto);
	service.createProjectionBooking(dto);
    }

    @PatchMapping("/projection/{id}/update")
    public void updateProjection(@PathVariable("id") Long id, @RequestBody ProjectionDTO dto) {
	System.out.println(dto);
	service.updateProjection(id, dto);
    }

    @PatchMapping("/projectionbooking/{id}/update")
    public void updateProjectionBooking(@PathVariable("id") Long id, @RequestBody ProjectionBookingDTO dto) {
	System.out.println(dto);
	service.updateProjectionBooking(id, dto);
    }

}
