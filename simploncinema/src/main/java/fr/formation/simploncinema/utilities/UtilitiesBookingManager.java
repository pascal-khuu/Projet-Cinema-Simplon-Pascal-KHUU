package fr.formation.simploncinema.utilities;

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

public interface UtilitiesBookingManager {

    // Algo conversion de DTO vers Entities
    List<TicketDTO> getTicketsDTO(List<Ticket> tickets);
    List<ProjectionBookingDTO> getProjectionBookingsDTO(List<ProjectionBooking> sessionbookings);
    List<PendingTicketDTO> getPendingTicketsDTO(List<PendingTicket> pendingtickets);
    List<PendingBookingDTO> getPendingbookingsDTO(List<PendingBooking> pendingbookings);
    List<BookingDTO> getBookingsDTO(List<Booking> bookings);
    List<BookedTicketDTO> getBookedTicketsDTO(List<BookedTicket> bookedtickets);
    TicketDTO getTicketDTO(Ticket ticket, ProjectionBooking sessionBooking);
    ProjectionBookingDTO getProjectionBookingDTO(ProjectionBooking sessionbooking);
    PendingTicketDTO getPendingTicketDTO(PendingTicket pendingticket);
    PendingBookingDTO getPendingBookingDTO(PendingBooking pendingbooking);
    BookingDTO getBookingDTO(Booking booking);
    BookedTicketDTO getBookedTicketDTO(BookedTicket bookedticket);

    // Algo conversion de Entities vers DTO
    Ticket getTicket(TicketDTO ticketDTO, ProjectionBookingDTO sessionBookingDTO);
    ProjectionBooking getProjectionBooking(ProjectionBookingDTO sessionbookingDTO);
    PendingTicket getPendingTicket(PendingTicketDTO pendingticketDTO);
    PendingBooking getPendingBooking(PendingBookingDTO pendingbookingDTO);
    Booking getBooking(BookingDTO bookingDTO);
    BookedTicket getBookedTicket(BookedTicketDTO bookedticketDTO);
    List<Ticket> getTickets(List<TicketDTO> ticketsDTO);
    List<PendingTicket> getPendingTickets(List<PendingTicketDTO> pendingticketsDTO);

}
