package fr.formation.simploncinema.service.booking;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import fr.formation.simploncinema.domain.dtos.booking.*;
import fr.formation.simploncinema.domain.entities.booking.PendingBooking;

public interface BookingManagerService {

	Optional<BookingDTO>  getBookingById(long id);

    void deleteBooking(long id);

	List<BookingDTO> findAllBookings();
	
	public void createBooking(long refpendingbooking) throws ParseException;
	
	public void confirmedPendingBooking(PendingBooking pendingBooking) ;

}
