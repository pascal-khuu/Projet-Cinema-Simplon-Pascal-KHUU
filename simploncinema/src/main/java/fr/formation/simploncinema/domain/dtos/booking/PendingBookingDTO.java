package fr.formation.simploncinema.domain.dtos.booking;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import fr.formation.simploncinema.domain.dtos.movietheater.*;
import fr.formation.simploncinema.domain.entities.booking.Ticket;
import fr.formation.simploncinema.domain.entities.movietheater.Projection;


public class PendingBookingDTO {

    public PendingBookingDTO() {

    }

    private MeansOfPaymentDTO meansofpayment;
    
    private double totalrate;
    
    private ProjectionDTO projection;

    private List<PendingTicketDTO> pendingtickets=new ArrayList<PendingTicketDTO>();;

    private long numberofseatschosen;

    private String status;
	private long refpendingbooking;
    private long rownumber;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    private Date creationdate;
    
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    private Date modificationdate;


	public MeansOfPaymentDTO getMeansofpayment() {
		return meansofpayment;
	}

	public void setMeansofpayment(MeansOfPaymentDTO meansofpayment) {
		this.meansofpayment = meansofpayment;
	}



/*	public ProjectionBookingDTO getSessionbooking() {
		return sessionbooking;
	}

	public void setSessionbooking(ProjectionBookingDTO sessionbooking) {
		this.sessionbooking = sessionbooking;
	}*/

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

	public List<PendingTicketDTO> getPendingtickets() {
		return pendingtickets;
	}

	public void setPendingtickets(List<PendingTicketDTO> pendingtickets) {
		this.pendingtickets.addAll(pendingtickets);
	    for (PendingTicketDTO pendingDTO: pendingtickets)
	    	pendingDTO.setPendingbooking(this);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Date getModificationdate() {
		return modificationdate;
	}

	public void setModificationdate(Date modificationdate) {
		this.modificationdate = modificationdate;
	}

	public double getTotalrate() {
		return totalrate;
	}

	public void setTotalrate(double totalrate) {
		this.totalrate = totalrate;
	}

	public long getRefpendingbooking() {
		return refpendingbooking;
	}

	public void setRefpendingbooking(long refpendingbooking) {
		this.refpendingbooking = refpendingbooking;
	}

	public ProjectionDTO getProjection() {
		return projection;
	}

	public void setProjection(ProjectionDTO projection) {
		this.projection = projection;
	}


    
}
