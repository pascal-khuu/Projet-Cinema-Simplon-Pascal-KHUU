package fr.formation.simploncinema.service.booking;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.formation.simploncinema.domain.dtos.booking.BookingDTO;
import fr.formation.simploncinema.domain.entities.booking.BookedTicket;
import fr.formation.simploncinema.domain.entities.booking.Booking;
import fr.formation.simploncinema.domain.entities.booking.PendingBooking;
import fr.formation.simploncinema.domain.entities.booking.PendingTicket;
import fr.formation.simploncinema.domain.entities.booking.ProjectionBooking;
import fr.formation.simploncinema.domain.entities.booking.Ticket;
import fr.formation.simploncinema.repository.booking.BookedTicketRepository;
import fr.formation.simploncinema.repository.booking.BookingRepository;
import fr.formation.simploncinema.repository.booking.PendingBookingRepository;
import fr.formation.simploncinema.repository.booking.ProjectionBookingRepository;
import fr.formation.simploncinema.utilities.UtilitiesAlgoManagerImpl;

@Service
public class BookingManagerServiceImpl extends UtilitiesAlgoManagerImpl
		implements BookingManagerService {

	private final BookingRepository repository;
	private final BookedTicketRepository bookedTicketrepository;
	private final PendingBookingRepository pendingBookingRepository;
	private final ProjectionBookingRepository sessionBookingRepository;

	public BookingManagerServiceImpl(BookingRepository repository, BookedTicketRepository bookedTicketrepository,
			PendingBookingRepository pendingBookingRepository,ProjectionBookingRepository sessionBookingRepository) {
		this.repository = repository;
		this.bookedTicketrepository = bookedTicketrepository;
		this.pendingBookingRepository=pendingBookingRepository;
		this.sessionBookingRepository=sessionBookingRepository;

	}

	@Override
	public Optional<BookingDTO> getBookingById(long refpendingbooking) {
		BookingDTO bookingDTO = new BookingDTO();
		Booking booking = repository.findById(refpendingbooking).get();
		bookingDTO = getBookingDTO(booking);
		return Optional.of(bookingDTO);

	}

	@Override
	public void createBooking(long refpendingbooking) throws ParseException {

		Booking booking = new Booking();
		List<BookedTicket> bookedTickets=new ArrayList<BookedTicket>();

		PendingBooking pendingBooking = pendingBookingRepository.findById(refpendingbooking).get();
		List<Booking> bookings = repository.findAll();
		List<BookedTicket> bookedtickets=bookedTicketrepository.findAll();
	
		confirmedPendingBooking(pendingBooking);
		
		
		booking=initBooking(pendingBooking,bookings);
		
		
		long refbookedticket = getNumberIDReference(bookedtickets.size());

		for(int i=0;i<pendingBooking.getPendingtickets().size();i++) {
			PendingTicket pendingTicket=pendingBooking.getPendingtickets().get(i);	
			BookedTicket bookedTicket=initBookedTicket(booking,pendingTicket,refbookedticket);
			bookedTickets.add(bookedTicket);
			refbookedticket++;
		}
		
		booking.setBookedtickets(bookedTickets);
		
	/*	for (int i=0;i<pendingBooking.getSessionbooking().getTickets().size();i++) {
			Ticket ticket=pendingBooking.getSessionbooking().getTickets().get(i);
			
			for (int j=0;j<bookedTickets.size();j++) {
				BookedTicket bookedTicket=bookedTickets.get(j);
				
				if(ticket.getSeatnumber()==bookedTicket.getSeatnumber()) {
					ticket.setIsregistered(true);
				}

			}	
			
		}*/
		ProjectionBooking sessionBooking = sessionBookingRepository.findById(pendingBooking.getProjection().getId()).get();

		for (int i=0;i<sessionBooking.getTickets().size();i++) {
			Ticket ticket=sessionBooking.getTickets().get(i);
			
			for (int j=0;j<bookedTickets.size();j++) {
				BookedTicket bookedTicket=bookedTickets.get(j);
				
				if(ticket.getSeatnumber()==bookedTicket.getSeatnumber()) {
					ticket.setIsregistered(true);
				}

			}	
			
		}
		
		repository.save(booking);

	}

	@Override
	public void deleteBooking(long refpendingbooking) {
		repository.deleteById(refpendingbooking);

	}

	
	@Override
	public List<BookingDTO> findAllBookings() {
		List<Booking> bookings = repository.findAll();
		List<BookingDTO> bookingsDTO = getBookingsDTO(bookings);

		return bookingsDTO;
	}
	
	@Override
	public void confirmedPendingBooking(PendingBooking pendingBooking ) {

		pendingBooking.setStatus("CONFIRMED");
		
		pendingBooking=changeStatusToConfirmed(pendingBooking);
		
		pendingBookingRepository.save(pendingBooking);
		
	}


}
