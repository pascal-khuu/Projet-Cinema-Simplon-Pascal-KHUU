package fr.formation.simploncinema.service.booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.formation.simploncinema.domain.dtos.movietheater.*;
import fr.formation.simploncinema.domain.dtos.booking.*;
import fr.formation.simploncinema.domain.entities.movietheater.*;
import fr.formation.simploncinema.domain.entities.booking.*;
import fr.formation.simploncinema.repository.booking.*;
import fr.formation.simploncinema.utilities.*;

@Service
public class ProjectionManagerServiceImpl extends UtilitiesAlgoManagerImpl
implements ProjectionManagerService  {

	private final ProjectionBookingRepository repository;
	private final TicketRepository repositoryTickets;
	private final ProjectionRepository Projectionrepository;
	private final BookingRepository bookingRepository;
	private final PendingBookingRepository pendingBookingsRepo;

	public ProjectionManagerServiceImpl(ProjectionBookingRepository repository,
			TicketRepository repositoryTickets, ProjectionRepository Projectionrepository,
			BookingRepository bookingRepository,PendingBookingRepository pendingBookingsRepo) {
		this.repository = repository;
		this.repositoryTickets=repositoryTickets;
		this.Projectionrepository=Projectionrepository;
		this.bookingRepository=bookingRepository;
		this.pendingBookingsRepo=pendingBookingsRepo;
	}

	@Override
	public Optional<ProjectionBookingDTO> getProjectionBookingById(long refProjectionbooking) {
		ProjectionBookingDTO ProjectionBookingDTO = new ProjectionBookingDTO();
		ProjectionBooking ProjectionBooking = repository.findById(refProjectionbooking).get();
		ProjectionBookingDTO=getProjectionBookingDTO(ProjectionBooking);

		return Optional.of(ProjectionBookingDTO);
	}

	@Override
	public void createProjectionBooking(ProjectionBookingDTO ProjectionBookingDTO) {

		ProjectionBooking ProjectionBooking = new ProjectionBooking();
		Projection Projection = getProjection(ProjectionBookingDTO.getProjection());	
		List<Ticket> tickets=repositoryTickets.findAll(); 
		List<ProjectionBooking> ProjectionBookings = repository.findAll();
		ProjectionBooking=initProjectionBooking(Projection,ProjectionBookings);
		List<Ticket> ticketsProjectionBooking=new ArrayList<Ticket>();
		
		int seatnumber=1;		
		long refticket=getNumberIDReference(tickets.size());
		for(int rownnumber=1;rownnumber<=Projection.getRoom().getNumberofrows();rownnumber++) {
			for (int numberseatsbyrow=0;numberseatsbyrow<Projection.getRoom().getNumberofseatsbyrow();numberseatsbyrow++) {
				Ticket ticket =initTicket(ProjectionBooking,rownnumber,refticket,seatnumber);
				ticketsProjectionBooking.add(ticket);		
				seatnumber++;
				refticket++;
			}
			
		}
		
		
		ProjectionBooking.setTickets(ticketsProjectionBooking);
		repository.save(ProjectionBooking);

	}

	@Override
	public void updateProjectionBooking(long refProjectionbooking, ProjectionBookingDTO ProjectionBookingDTO) {

		ProjectionBooking ProjectionBooking = repository.findById(refProjectionbooking).get();
		ProjectionBooking=getProjectionBooking(ProjectionBookingDTO);
		repository.save(ProjectionBooking);

	}

	@Override
	public void deleteProjectionBooking(long refProjectionbooking) {
		List<Booking> bookings=bookingRepository.findAll();
		List<PendingBooking> pendingBookings=pendingBookingsRepo.findAll();
		
		List<Booking> bookingsToDelete=new ArrayList<Booking>();
		List<PendingBooking> pendingbookingsToDelete=new ArrayList<PendingBooking>();

		for(int i=0;i<bookings.size();i++) {
			if(bookings.get(i).getProjection().getId()==refProjectionbooking){
				bookingsToDelete.add(bookings.get(i));
			}
		}
		
		for(int i=0;i<pendingBookings.size();i++) {
			if(pendingBookings.get(i).getProjection().getId()==refProjectionbooking){
				pendingbookingsToDelete.add(pendingBookings.get(i));
			}
		}
		bookingRepository.deleteAll(bookingsToDelete);
		pendingBookingsRepo.deleteAll(pendingbookingsToDelete);
		
		
		repository.deleteById(refProjectionbooking);

	}

	@Override
	public List<ProjectionBookingDTO> findAllBookingProjections() {
		List<ProjectionBooking> ProjectionBookings = repository.findAll();
		List<ProjectionBookingDTO> ProjectionBookingsDTO = getProjectionBookingsDTO(ProjectionBookings);

		return ProjectionBookingsDTO;
	}

	

	@Override
	public Optional<ProjectionDTO> getProjectionById(long refProjection) {
		Projection Projection = Projectionrepository.findById(refProjection).get();
		ProjectionDTO ProjectionDTO= getProjectionDTO(Projection);
		return Optional.of(ProjectionDTO);
	}

	@Override
	public List<ProjectionDTO> findAllProjections() {
		List<Projection> Projections = Projectionrepository.findAll();
		List<ProjectionDTO> ProjectionsDTO = getProjectionsDTO(Projections);

		return ProjectionsDTO;
	}

	@Override
	public List<ProjectionDTO> getProjectionByMovieAndMovieTheater(String movietheatername, String moviename) {
		List<ProjectionDTO> ProjectionsDTO = findAllProjections();
		List<ProjectionDTO> ProjectionDTObyMovienameAndTheater = new ArrayList<ProjectionDTO>();

		for (int i = 0; i < ProjectionsDTO.size(); i++) {

			ProjectionDTO ProjectionDTO = ProjectionsDTO.get(i);
			MovieDTO movieDTO = ProjectionDTO.getMovie();
			MovieTheaterDTO movieTheaterDTO = ProjectionDTO.getMovieTheater();

			if (moviename.equals(movieDTO.getMoviename())
					&& movietheatername.equals(movieTheaterDTO.getMovietheatername())) {
				ProjectionDTObyMovienameAndTheater.add(ProjectionDTO);
			}
		}

		return ProjectionDTObyMovienameAndTheater;
	}

	@Override
	public List<ProjectionDTO> getProjectionByMovieTheater(String movietheatername) {
		List<ProjectionDTO> ProjectionsDTO = findAllProjections();
		List<ProjectionDTO> ProjectionDTObyMovieTheater = new ArrayList<ProjectionDTO>();

		for (int i = 0; i < ProjectionsDTO.size(); i++) {

			ProjectionDTO ProjectionDTO = ProjectionsDTO.get(i);
			MovieTheaterDTO movieTheaterDTO = ProjectionDTO.getMovieTheater();

			if (movietheatername.equals(movieTheaterDTO.getMovietheatername())) {
				ProjectionDTObyMovieTheater.add(ProjectionDTO);
			}
		}

		return ProjectionDTObyMovieTheater;
	}

	@Override
	public List<ProjectionDTO> getProjectionByProjectiondate(Date projectiondate) {
		List<Projection> Projections = Projectionrepository.findByProjectiondate(projectiondate);
		
		List<ProjectionDTO> ProjectionsDTO=getProjectionsDTO(Projections);
		List<ProjectionDTO> ProjectionDTObyProjectiondate = new ArrayList<ProjectionDTO>();

		for (int i = 0; i < ProjectionsDTO.size(); i++) {

			ProjectionDTO ProjectionDTO = ProjectionsDTO.get(i);

			if (projectiondate.equals(ProjectionDTO.getProjectiondate())) {
				ProjectionDTObyProjectiondate.add(ProjectionDTO);
			}
		}

		return ProjectionDTObyProjectiondate;
	}
	
	
	

	@Override
	public void updateProjection(long refProjection, ProjectionDTO ProjectionDTO) {
		Projection Projection = Projectionrepository.findById(refProjection).get();
		Projection=getProjection(ProjectionDTO);
		Projectionrepository.save(Projection);
		
	}

	@Override
	public List<ProjectionDTO> getProjectionByMovieTheaterProjectiondate(Date projectiondate, String movietheatername) {
		List<Projection> Projections = Projectionrepository.findByProjectiondate(projectiondate);	
		List<ProjectionDTO> ProjectionsDTO=getProjectionsDTO(Projections);
		
		ArrayList<ProjectionDTO> ProjectionDTObyMovieTheaterAndProjectiondate = new ArrayList<ProjectionDTO>();
		for (int i = 0; i < ProjectionsDTO.size(); i++) {

			ProjectionDTO ProjectionDTO = ProjectionsDTO.get(i);
			MovieTheaterDTO movieTheaterDTO = ProjectionDTO.getMovieTheater();

			if (projectiondate.equals(ProjectionDTO.getProjectiondate())
					&& movietheatername.equals(movieTheaterDTO.getMovietheatername())) {
				ProjectionDTObyMovieTheaterAndProjectiondate.add(ProjectionDTO);
			}
		}

		return ProjectionDTObyMovieTheaterAndProjectiondate;
	}

	@Override
	public List<ProjectionDTO> getProjectionByMovieTheaterAndProjectiondateAndMoviename(Date projectiondate,
			String movietheatername, String moviename) {
		List<Projection> projections = Projectionrepository.findByProjectiondate(projectiondate);
		List<ProjectionDTO> projectionsDTO=getProjectionsDTO(projections);
		
		List<ProjectionDTO> projectionDTObyMovieTheaterAndProjectiondateAndMoviename = new ArrayList<ProjectionDTO>();

		for (int i = 0; i < projectionsDTO.size(); i++) {

			ProjectionDTO ProjectionDTO = projectionsDTO.get(i);
			MovieDTO movieDTO=projectionsDTO.get(i).getMovie();
			MovieTheaterDTO movieTheaterDTO = ProjectionDTO.getMovieTheater();

			if (projectiondate.equals(ProjectionDTO.getProjectiondate())
					&& movietheatername.equals(movieTheaterDTO.getMovietheatername()) && moviename.equals(movieDTO.getMoviename())) {
				projectionDTObyMovieTheaterAndProjectiondateAndMoviename.add(ProjectionDTO);
			}
		}

		return projectionDTObyMovieTheaterAndProjectiondateAndMoviename;
	}


}
