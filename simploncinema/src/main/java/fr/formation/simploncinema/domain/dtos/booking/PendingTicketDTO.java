package fr.formation.simploncinema.domain.dtos.booking;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import fr.formation.simploncinema.domain.dtos.movietheater.RateDTO;

public class PendingTicketDTO {

    public PendingTicketDTO() {

    }

	private long refpendingticket;
    
    private PendingBookingDTO pendingbooking;

    private RateDTO rate;
    
    private boolean isproposed;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    private Date modificationdate;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    private Date creationdate;
    

    private long rownumber;
    

    private long seatnumber;
    

    private long numberofseatschosen;



	public long getRownumber() {
		return rownumber;
	}


	public void setRownumber(long rownumber) {
		this.rownumber = rownumber;
	}


	public long getSeatnumber() {
		return seatnumber;
	}


	public void setSeatnumber(long seatnumber) {
		this.seatnumber = seatnumber;
	}


	public PendingBookingDTO getPendingbooking() {
		return pendingbooking;
	}


	public void setPendingbooking(PendingBookingDTO pendingbooking) {
		this.pendingbooking = pendingbooking;
	}


	public RateDTO getRate() {
		return rate;
	}


	public void setRate(RateDTO rate) {
		this.rate = rate;
	}


	public boolean isIsproposed() {
		return isproposed;
	}


	public void setIsproposed(boolean isproposed) {
		this.isproposed = isproposed;
	}


	public Date getModificationdate() {
		return modificationdate;
	}


	public void setModificationdate(Date modificationdate) {
		this.modificationdate = modificationdate;
	}


	public Date getCreationdate() {
		return creationdate;
	}


	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}


	public long getNumberofseats() {
		return numberofseatschosen;
	}


	public void setNumberofseatschosen(long numberofseatschosen) {
		this.numberofseatschosen = numberofseatschosen;
	}


	public long getRefpendingticket() {
		return refpendingticket;
	}


	public void setRefpendingticket(long refpendingticket) {
		this.refpendingticket = refpendingticket;
	}


	public long getNumberofseatschosen() {
		return numberofseatschosen;
	}


    
    
}
