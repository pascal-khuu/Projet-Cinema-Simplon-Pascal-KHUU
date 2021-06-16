package fr.formation.simploncinema.domain.dtos.booking;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import fr.formation.simploncinema.domain.dtos.movietheater.RateDTO;


public class BookedTicketDTO {

    public BookedTicketDTO() {

    }

    private BookingDTO booking;

    private RateDTO rate;
    private long refbookedticket;
 
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    private Date registrationdate;
    

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


	public Date getRegistrationdate() {
		return registrationdate;
	}


	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}


	public long getNumberofseatschosen() {
		return numberofseatschosen;
	}


	public void setNumberofseatschosen(long numberofseatschosen) {
		this.numberofseatschosen = numberofseatschosen;
	}


	public BookingDTO getBooking() {
		return booking;
	}


	public void setBooking(BookingDTO booking) {
		this.booking = booking;
	}


	public RateDTO getRate() {
		return rate;
	}


	public void setRate(RateDTO rate) {
		this.rate = rate;
	}


	public long getRefbookedticket() {
		return refbookedticket;
	}


	public void setRefbookedticket(long refbookedticket) {
		this.refbookedticket = refbookedticket;
	}


	
    
    
}
