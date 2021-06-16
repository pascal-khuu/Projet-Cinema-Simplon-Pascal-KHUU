package fr.formation.simploncinema.domain.dtos.booking;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import fr.formation.simploncinema.domain.dtos.movietheater.MeansOfPaymentDTO;
import fr.formation.simploncinema.domain.dtos.movietheater.ProjectionDTO;
import fr.formation.simploncinema.domain.dtos.referentials.ClientDTO;

public class BookingDTO {

    
    public BookingDTO() {

    }
    private double totalrate;
	private long refbooking;
    
    private MeansOfPaymentDTO meansofpayment;

    private ClientDTO client;

    private ProjectionDTO projection;

    private List<BookedTicketDTO> bookedtickets=new ArrayList<BookedTicketDTO>();;

    private long numberofseatschosen;

    private long rownumber;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    private Date registrationdate;


	public MeansOfPaymentDTO getMeansofpayment() {
		return meansofpayment;
	}

	public void setMeansofpayment(MeansOfPaymentDTO meansofpayment) {
		this.meansofpayment = meansofpayment;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}


	

	public ProjectionDTO getProjection() {
		return projection;
	}

	public void setProjection(ProjectionDTO projection) {
		this.projection = projection;
	}

	public List<BookedTicketDTO> getBookedtickets() {
		return bookedtickets;
	}

	public void setBookedtickets(List<BookedTicketDTO> bookedtickets) {
		this.bookedtickets.addAll(bookedtickets);
	    for (BookedTicketDTO bookedTicket: bookedtickets)
	    	bookedTicket.setBooking(this);
	}

	public long getNumberofseatschosen() {
		return numberofseatschosen;
	}

	public void setNumberofseatschosen(long numberofseatschosen) {
		this.numberofseatschosen = numberofseatschosen;
	}

	public long getRownumber() {
		return rownumber;
	}

	public void setRownumber(long rownumber) {
		this.rownumber = rownumber;
	}

	public Date getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}

	public long getRefbooking() {
		return refbooking;
	}

	public void setRefbooking(long refbooking) {
		this.refbooking = refbooking;
	}

	public double getTotalrate() {
		return totalrate;
	}

	public void setTotalrate(double totalrate) {
		this.totalrate = totalrate;
	}
       
    
    
    
    
}
