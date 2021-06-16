package fr.formation.simploncinema.utilities;

import java.util.ArrayList;
import java.util.List;

import fr.formation.simploncinema.domain.dtos.booking.BookedTicketDTO;
import fr.formation.simploncinema.domain.dtos.booking.BookingDTO;
import fr.formation.simploncinema.domain.dtos.booking.PendingBookingDTO;
import fr.formation.simploncinema.domain.dtos.booking.PendingTicketDTO;
import fr.formation.simploncinema.domain.dtos.booking.ProjectionBookingDTO;
import fr.formation.simploncinema.domain.dtos.booking.TicketDTO;
import fr.formation.simploncinema.domain.entities.booking.BookedTicket;
import fr.formation.simploncinema.domain.entities.booking.Booking;
import fr.formation.simploncinema.domain.entities.booking.PendingBooking;
import fr.formation.simploncinema.domain.entities.booking.PendingTicket;
import fr.formation.simploncinema.domain.entities.booking.ProjectionBooking;
import fr.formation.simploncinema.domain.entities.booking.Ticket;

public class UtilitiesBookingManagerImpl extends UtilitiesDataManagerImpl implements UtilitiesBookingManager {

	@Override
	public List<TicketDTO> getTicketsDTO(List<Ticket> tickets) {
		ArrayList<TicketDTO> ticketsDTO = new ArrayList<TicketDTO>();
		for (int i = 0; i < tickets.size(); i++) {
			TicketDTO ticketDTO = getTicketDTO(tickets.get(i), tickets.get(i).getProjectionbooking());
			ticketsDTO.add(ticketDTO);
		}
		return ticketsDTO;
	}

	@Override
	public List<Ticket> getTickets(List<TicketDTO> ticketsDTO) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		for (int i = 0; i < ticketsDTO.size(); i++) {
			Ticket ticket = getTicket(ticketsDTO.get(i), ticketsDTO.get(i).getProjectionbooking());
			tickets.add(ticket);
		}
		return tickets;
	}

	@Override
	public List<ProjectionBookingDTO> getProjectionBookingsDTO(List<ProjectionBooking> projectionbookings) {
		ArrayList<ProjectionBookingDTO> projectionbookingsDTO = new ArrayList<ProjectionBookingDTO>();
		for (int i = 0; i < projectionbookings.size(); i++) {
			ProjectionBookingDTO projectionbooking = getProjectionBookingDTO(projectionbookings.get(i));
			projectionbookingsDTO.add(projectionbooking);
		}
		return projectionbookingsDTO;
	}

	@Override
	public List<PendingTicketDTO> getPendingTicketsDTO(List<PendingTicket> pendingtickets) {
		ArrayList<PendingTicketDTO> pendingticketsDTO = new ArrayList<PendingTicketDTO>();
		for (int i = 0; i < pendingtickets.size(); i++) {
			PendingTicketDTO pendingticket = getPendingTicketDTO(pendingtickets.get(i));
			pendingticketsDTO.add(pendingticket);
		}
		return pendingticketsDTO;
	}
	
	@Override
	public List<PendingTicket> getPendingTickets(List<PendingTicketDTO> pendingticketsDTO) {
		ArrayList<PendingTicket> pendingtickets = new ArrayList<PendingTicket>();
		for (int i = 0; i < pendingticketsDTO.size(); i++) {
			PendingTicket pendingticket = getPendingTicket(pendingticketsDTO.get(i));
			pendingtickets.add(pendingticket);
		}
		return pendingtickets;
	}


	@Override
	public List<PendingBookingDTO> getPendingbookingsDTO(List<PendingBooking> pendingbookings) {
		List<PendingBookingDTO> pendingbookingsDTO = new ArrayList<PendingBookingDTO>();
		for (int i = 0; i < pendingbookings.size(); i++) {
			PendingBookingDTO pendingbooking = getPendingBookingDTO(pendingbookings.get(i));
			pendingbookingsDTO.add(pendingbooking);
		}
		return pendingbookingsDTO;
	}

	@Override
	public List<BookingDTO> getBookingsDTO(List<Booking> bookings) {
		List<BookingDTO> bookingsDTO = new ArrayList<BookingDTO>();
		for (int i = 0; i < bookings.size(); i++) {
			BookingDTO booking = getBookingDTO(bookings.get(i));
			bookingsDTO.add(booking);
		}
		return bookingsDTO;
	}

	@Override
	public List<BookedTicketDTO> getBookedTicketsDTO(List<BookedTicket> bookedtickets) {
		ArrayList<BookedTicketDTO> bookedticketsDTO = new ArrayList<BookedTicketDTO>();
		for (int i = 0; i < bookedtickets.size(); i++) {
			BookedTicketDTO bookedTicketDTO = getBookedTicketDTO(bookedtickets.get(i));
			bookedticketsDTO.add(bookedTicketDTO);
		}
		return bookedticketsDTO;
	}

	@Override
	public TicketDTO getTicketDTO(Ticket ticket, ProjectionBooking projectionBooking) {
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO.setIsregistered(ticket.isIsregistered());
		ticketDTO.setRefticket(ticket.getRefticket());
		ticketDTO.setRownumber(ticket.getRownumber());
		ticketDTO.setSeatnumber(ticket.getSeatnumber());
	//	ticketDTO.setprojectionbooking(getprojectionBookingDTO(projectionBooking));
		return ticketDTO;
	}

	@Override
	public ProjectionBookingDTO getProjectionBookingDTO(ProjectionBooking projectionbooking) {
		ProjectionBookingDTO projectionBookingDTO = new ProjectionBookingDTO();
		projectionBookingDTO.setRefprojectionbooking(projectionbooking.getRefprojectionbooking());
		projectionBookingDTO.setProjection(getProjectionDTO(projectionbooking.getProjection()));
		
		List<TicketDTO> ticketsDTO = getTicketsDTO(projectionbooking.getTickets());
		projectionBookingDTO.setTickets(ticketsDTO);
		return projectionBookingDTO;
	}

	@Override
	public PendingTicketDTO getPendingTicketDTO(PendingTicket pendingticket) {
		PendingTicketDTO pendingticketDTO = new PendingTicketDTO();
		pendingticketDTO.setRefpendingticket(pendingticket.getRefpendingticket());
		//pendingticketDTO.setPendingbooking(getPendingBookingDTO(pendingticket.getPendingbooking()));
		pendingticketDTO.setRate(getRateDTO(pendingticket.getRate()));
		pendingticketDTO.setIsproposed(pendingticket.isIsproposed());
		pendingticketDTO.setModificationdate(pendingticket.getModificationdate());
		pendingticketDTO.setCreationdate(pendingticket.getCreationdate());
		pendingticketDTO.setRownumber(pendingticket.getRownumber());
		pendingticketDTO.setSeatnumber(pendingticket.getSeatnumber());
		pendingticketDTO.setNumberofseatschosen(pendingticket.getNumberofseatschosen());

		return pendingticketDTO;
	}

	@Override
	public PendingBookingDTO getPendingBookingDTO(PendingBooking pendingbooking) {
		PendingBookingDTO pendingbookingDTO = new PendingBookingDTO();
		pendingbookingDTO.setTotalrate(pendingbooking.getTotalrate());
		pendingbookingDTO.setNumberofseatschosen(pendingbooking.getNumberofseatschosen());
		pendingbookingDTO.setStatus(pendingbooking.getStatus());
		pendingbookingDTO.setRefpendingbooking(pendingbooking.getRefpendingbooking());
		pendingbookingDTO.setRownumber(pendingbooking.getRownumber());
		pendingbookingDTO.setCreationdate(pendingbooking.getCreationdate());
		pendingbookingDTO.setModificationdate(pendingbooking.getModificationdate());
	//	pendingbookingDTO.setprojectionbooking(getprojectionBookingDTO(pendingbooking.getprojectionbooking()));
		pendingbookingDTO.setProjection(getProjectionDTO(pendingbooking.getProjection()));
		pendingbookingDTO.setMeansofpayment(getMeansOfPaymentDTO(pendingbooking.getMeansofpayment()).get());
		pendingbookingDTO.setPendingtickets(getPendingTicketsDTO(pendingbooking.getPendingtickets()));
		return pendingbookingDTO;
	}

	@Override
	public BookingDTO getBookingDTO(Booking booking) {
		BookingDTO bookingDTO = new BookingDTO();
		bookingDTO.setTotalrate(booking.getTotalrate());
		bookingDTO.setNumberofseatschosen(booking.getNumberofseatschosen());
		bookingDTO.setRefbooking(booking.getRefbooking());
		bookingDTO.setRownumber(booking.getRownumber());
		bookingDTO.setRegistrationdate(booking.getRegistrationdate());
		bookingDTO.setProjection(getProjectionDTO(booking.getProjection()));
		bookingDTO.setClient(getClientDTO(booking.getClient(), booking.getClient().getAddress()));
		bookingDTO.setMeansofpayment(getMeansOfPaymentDTO(booking.getMeansofpayment()).get());
		bookingDTO.setBookedtickets(getBookedTicketsDTO(booking.getBookedtickets()));

		
		return bookingDTO;
	}

	@Override
	public BookedTicketDTO getBookedTicketDTO(BookedTicket bookedticket) {
		BookedTicketDTO bookedTicketDTO = new BookedTicketDTO();
		bookedTicketDTO.setRefbookedticket(bookedticket.getRefbookedticket());
	//		bookedTicketDTO.setBooking(getBookingDTO(bookedticket.getBooking()));
		bookedTicketDTO.setRate(getRateDTO(bookedticket.getRate()));
		bookedTicketDTO.setRegistrationdate(bookedticket.getRegistrationdate());
		bookedTicketDTO.setRownumber(bookedticket.getRownumber());
		bookedTicketDTO.setSeatnumber(bookedticket.getSeatnumber());
		bookedTicketDTO.setNumberofseatschosen(bookedticket.getNumberofseatschosen());

		return bookedTicketDTO;
	}

	@Override
	public ProjectionBooking getProjectionBooking(ProjectionBookingDTO projectionbookingDTO) {
		ProjectionBooking projectionbooking = new ProjectionBooking();
		projectionbooking.setRefprojectionbooking(projectionbookingDTO.getRefprojectionbooking());
		projectionbooking.setProjection(getProjection(projectionbookingDTO.getProjection()));
		List<Ticket> tickets = getTickets(projectionbookingDTO.getTickets());
		projectionbooking.setTickets(tickets);
		return projectionbooking;
	}

	@Override
	public Ticket getTicket(TicketDTO ticketDTO, ProjectionBookingDTO projectionBookingDTO) {
		Ticket ticket = new Ticket();
		ticket.setIsregistered(ticketDTO.isIsregistered());
		ticket.setRefticket(ticketDTO.getRefticket());
		ticket.setRownumber(ticketDTO.getRownumber());
		ticket.setSeatnumber(ticketDTO.getSeatnumber());
		ticket.setProjectionbooking(getProjectionBooking(projectionBookingDTO));
		return ticket;
	}

	@Override
	public PendingTicket getPendingTicket(PendingTicketDTO pendingticketDTO) {
		PendingTicket pendingticket = new PendingTicket();
		pendingticket.setRefpendingticket(pendingticketDTO.getRefpendingticket());
		//pendingticket.setPendingbooking(getPendingBooking(pendingticketDTO.getPendingbooking()));
		pendingticket.setRate(getRate(pendingticketDTO.getRate()));
		pendingticket.setIsproposed(pendingticketDTO.isIsproposed());
		pendingticket.setModificationdate(pendingticketDTO.getModificationdate());
		pendingticket.setCreationdate(pendingticketDTO.getCreationdate());
		pendingticket.setRownumber(pendingticketDTO.getRownumber());
		pendingticket.setSeatnumber(pendingticketDTO.getSeatnumber());
		pendingticket.setNumberofseatschosen(pendingticketDTO.getNumberofseatschosen());

		return pendingticket;
	}

	@Override
	public PendingBooking getPendingBooking(PendingBookingDTO pendingbookingDTO) {
		PendingBooking pendingbooking = new PendingBooking();
		pendingbooking.setTotalrate(pendingbookingDTO.getTotalrate());
		pendingbooking.setNumberofseatschosen(pendingbookingDTO.getNumberofseatschosen());
		pendingbooking.setStatus(pendingbookingDTO.getStatus());
		pendingbooking.setRefpendingbooking(pendingbookingDTO.getRefpendingbooking());
		pendingbooking.setRownumber(pendingbookingDTO.getRownumber());
		pendingbooking.setCreationdate(pendingbookingDTO.getCreationdate());
		pendingbooking.setModificationdate(pendingbookingDTO.getModificationdate());
	//	pendingbooking.setprojectionbooking(getprojectionBooking(pendingbookingDTO.getprojectionbooking()));
		pendingbooking.setMeansofpayment(getMeansOfPayment(pendingbookingDTO.getMeansofpayment()).get());
		pendingbooking.setProjection(getProjection(pendingbookingDTO.getProjection()));
		pendingbooking.setPendingtickets(getPendingTickets(pendingbookingDTO.getPendingtickets()));

		return pendingbooking;
	}

	@Override
	public Booking getBooking(BookingDTO bookingDTO) {
		Booking booking = new Booking();
		booking.setTotalrate(bookingDTO.getTotalrate());
		booking.setNumberofseatschosen(bookingDTO.getNumberofseatschosen());
		booking.setRefbooking(bookingDTO.getRefbooking());
		booking.setRownumber(bookingDTO.getRownumber());
		booking.setRegistrationdate(bookingDTO.getRegistrationdate());
		booking.setProjection(getProjection(bookingDTO.getProjection()));
		booking.setClient(getClient(bookingDTO.getClient(), bookingDTO.getClient().getAddress()));
		booking.setMeansofpayment(getMeansOfPayment(bookingDTO.getMeansofpayment()).get());
		return booking;
	}

	@Override
	public BookedTicket getBookedTicket(BookedTicketDTO bookedticketDTO) {
		BookedTicket bookedTicket = new BookedTicket();
		bookedTicket.setRefbookedticket(bookedticketDTO.getRefbookedticket());
		bookedTicket.setBooking(getBooking(bookedticketDTO.getBooking()));
		bookedTicket.setRate(getRate(bookedticketDTO.getRate()));
		bookedTicket.setRegistrationdate(bookedticketDTO.getRegistrationdate());
		bookedTicket.setRownumber(bookedticketDTO.getRownumber());
		bookedTicket.setSeatnumber(bookedticketDTO.getSeatnumber());
		bookedTicket.setNumberofseatschosen(bookedticketDTO.getNumberofseatschosen());

		return bookedTicket;
	}

	
	
}
