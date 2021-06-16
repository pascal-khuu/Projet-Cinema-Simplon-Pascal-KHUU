package fr.formation.simploncinema.service.booking;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import fr.formation.simploncinema.domain.dtos.booking.ProjectionBookingDTO;
import fr.formation.simploncinema.domain.dtos.movietheater.ProjectionDTO;

public interface ProjectionManagerService {

	Optional<ProjectionBookingDTO>  getProjectionBookingById(long id);

    void createProjectionBooking(ProjectionBookingDTO dto);
    void deleteProjectionBooking(long id);
    List<ProjectionBookingDTO> findAllBookingProjections();
	void updateProjectionBooking(long id, ProjectionBookingDTO projectionbookingDTO);
	
	
	List<ProjectionDTO> getProjectionByMovieAndMovieTheater(String movietheatername, String moviename);
	List<ProjectionDTO> getProjectionByMovieTheater(String movietheatername);
	List<ProjectionDTO> getProjectionByMovieTheaterProjectiondate(Date projectiondate, String movietheatername);
	List<ProjectionDTO> getProjectionByMovieTheaterAndProjectiondateAndMoviename(Date projectiondate, String movietheatername,String moviename);
	
	List<ProjectionDTO> getProjectionByProjectiondate(Date projectiondate);
	Optional<ProjectionDTO>  getProjectionById(long id);

	List<ProjectionDTO> findAllProjections();
	void updateProjection(long id, ProjectionDTO projectionDTO);
	
}
