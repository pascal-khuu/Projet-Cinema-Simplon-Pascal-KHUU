package fr.formation.simploncinema.domain.entities.booking;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import fr.formation.simploncinema.domain.entities.movietheater.Rate;

@Entity
@Table(name = "bookedticket")
public class BookedTicket {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "BOOKEDTICKET_ID")
    private long id;
    public BookedTicket() {

    }
    
    @Column(name = "refbookedticket")
	private long refbookedticket;
    
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="RATE_ID")
    private Rate rate;
    
    @ManyToOne
    @JoinColumn(name="BOOKING_ID")
    private Booking booking;
    
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    @Column(name="registrationdate")
    private Date registrationdate;
    
    
    @Column(name = "rownumber", nullable = false)
    private long rownumber;
    
    @Column(name = "seatnumber", nullable = false)
    private long seatnumber;
    
    
    @Column(name = "numberofseatschosen", nullable = false)
    private long numberofseatschosen;
    
    
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


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


	public long getRefbookedticket() {
		return refbookedticket;
	}


	public void setRefbookedticket(long refbookedticket) {
		this.refbookedticket = refbookedticket;
	}


	public Rate getRate() {
		return rate;
	}


	public void setRate(Rate rate) {
		this.rate = rate;
	}


	public Booking getBooking() {
		return booking;
	}


	public void setBooking(Booking booking) {
		this.booking = booking;
	}


	
    
    
}
