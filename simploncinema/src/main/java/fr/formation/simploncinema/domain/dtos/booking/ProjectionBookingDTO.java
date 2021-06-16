package fr.formation.simploncinema.domain.dtos.booking;

import java.util.ArrayList;
import java.util.List;

import fr.formation.simploncinema.domain.dtos.movietheater.*;
import fr.formation.simploncinema.domain.entities.booking.Ticket;

public class ProjectionBookingDTO {

    public ProjectionBookingDTO() {

    }

    private ProjectionDTO projection;
	private long refprojectionbooking;
  
    private List<TicketDTO> tickets=new ArrayList<TicketDTO>();;
	
	public List<TicketDTO> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketDTO> tickets) {
		this.tickets.addAll(tickets);
	    for (TicketDTO ticket: tickets)
	    	ticket.setProjectionbooking(this);
	}

	public ProjectionDTO getProjection() {
		return projection;
	}

	public void setProjection(ProjectionDTO projection) {
		this.projection = projection;
	}

	public long getRefprojectionbooking() {
		return refprojectionbooking;
	}

	public void setRefprojectionbooking(long refprojectionbooking) {
		this.refprojectionbooking = refprojectionbooking;
	}

	
    
 
    
    
}
