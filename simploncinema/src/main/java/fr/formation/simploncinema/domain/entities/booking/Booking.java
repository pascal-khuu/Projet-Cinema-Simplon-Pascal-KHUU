package fr.formation.simploncinema.domain.entities.booking;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonFormat;

import fr.formation.simploncinema.domain.entities.movietheater.MeansOfPayment;
import fr.formation.simploncinema.domain.entities.movietheater.Projection;
import fr.formation.simploncinema.domain.entities.referentials.Client;

@Entity
@Table(name = "booking")
public class Booking {

	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOKING_ID")
    private long id;

	 @Column(name = "refbooking")
		private long refbooking;
	
    public Booking() {

    }
    
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="MEANSOFPAYMENT_ID")
    private MeansOfPayment meansofpayment;
    
    
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="CLIENT_ID")
    private Client client;
    
    @ManyToOne //(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="PROJECTION_ID")
    private Projection projection;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<BookedTicket> bookedtickets=new ArrayList<BookedTicket>();
    
    @Column(name = "totalrate", nullable = false)
    private double totalrate;
    
    @Column(name = "numberofseatschosen", nullable = false)
    private long numberofseatschosen;
    @Column(name = "rownumber", nullable = false)
    private long rownumber;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    @Column(name="registrationdate")
    private Date registrationdate;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MeansOfPayment getMeansofpayment() {
		return meansofpayment;
	}

	public void setMeansofpayment(MeansOfPayment meansofpayment) {
		this.meansofpayment = meansofpayment;
	}



	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	public List<BookedTicket> getBookedtickets() {
		return bookedtickets;
	}

	public void setBookedtickets(List<BookedTicket> bookedtickets) {
		this.bookedtickets.addAll(bookedtickets);
	    for (BookedTicket bookedTicket: bookedtickets)
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

	public double getTotalrate() {
		return totalrate;
	}

	public void setTotalrate(double totalrate) {
		this.totalrate = totalrate;
	}

	public long getRefbooking() {
		return refbooking;
	}

	public void setRefbooking(long refbooking) {
		this.refbooking = refbooking;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	
    
}
