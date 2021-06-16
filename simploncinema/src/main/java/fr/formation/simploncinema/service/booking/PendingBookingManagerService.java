package fr.formation.simploncinema.service.booking;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import fr.formation.simploncinema.domain.dtos.booking.*;

public interface PendingBookingManagerService {

	Optional<PendingBookingDTO>  getPendingBookingById(long id);

    void createPendingBooking(long refClient, 
			String movietheatername, 
			Date projectiondate, String moviename) throws ParseException;
    void deletePendingBooking(long id);

	void updatePendingBooking(long id, PendingBookingDTO pendingbookingDTO);
	
	
	void updatePendingBookingChoixNumberSeats(long refpendingbooking, long numberseats) throws ParseException;
	
	void updatePendingBookingChoixNumberSeatsAndRows(long refpendingbooking, long numberseats, long row) throws ParseException;

	List<PendingBookingDTO> findAllPendingBookings();
	
	public void updatePendingBookingCB(long refpendingbooking, String meansOfPayment) throws ParseException;

	public void updatePendingBookingRates(long refpendingbooking, long
			numberticketsratenormal , 
			long numberticketsrate26, long numberticketsrate14) throws ParseException;
}
