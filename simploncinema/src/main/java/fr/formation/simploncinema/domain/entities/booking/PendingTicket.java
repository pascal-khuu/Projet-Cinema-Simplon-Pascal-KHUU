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
@Table(name = "pendingticket")
public class PendingTicket {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PENDINGTICKET_ID")
	private long id;
    public PendingTicket() {

    }
    @Column(name = "refpendingticket")
	private long refpendingticket;
    
    @ManyToOne
    @JoinColumn(name="PENDINGBOOKING_ID")
    private PendingBooking pendingbooking;
    
    
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="RATE_ID")
    private Rate rate;
    
    @Column(name = "isproposed", nullable = false)
    private boolean isproposed;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    @Column(name="modificationdate")
    private Date modificationdate;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    @Column(name="creationdate")
    private Date creationdate;
    
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


	public PendingBooking getPendingbooking() {
		return pendingbooking;
	}


	public void setPendingbooking(PendingBooking pendingbooking) {
		this.pendingbooking = pendingbooking;
	}


	public Rate getRate() {
		return rate;
	}


	public void setRate(Rate rate) {
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


	public long getNumberofseatschosen() {
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


    
    
}
