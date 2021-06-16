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
@Table(name = "pendingbooking")
public class PendingBooking {

	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PENDINGBOOKING_ID")
    private long id;
    
	 @Column(name = "refpendingbooking")
		private long refpendingbooking;
    
    public PendingBooking() {

    }
    
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="MEANSOFPAYMENT_ID")
    private MeansOfPayment meansofpayment;
    

    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="CLIENT_ID")
    private Client client;
    


    @ManyToOne//(fetch=FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name="PROJECTION_ID")
    private Projection projection;
    
    @OneToMany(mappedBy = "pendingbooking", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PendingTicket> pendingtickets=new ArrayList<PendingTicket>();
    
    @Column(name = "totalrate", nullable = false)
    private double totalrate;
    @Column(name = "numberofseatschosen", nullable = false)
    private long numberofseatschosen;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column(name = "rownumber", nullable = false)
    private long rownumber;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    @Column(name="creationdate")
    private Date creationdate;
    
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    @Column(name="modificationdate")
    private Date modificationdate;


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

	public List<PendingTicket> getPendingtickets() {
		return pendingtickets;
	}

	public void setPendingtickets(List<PendingTicket> pendingtickets) {
		this.pendingtickets.addAll(pendingtickets);
	    for (PendingTicket pendingticket: pendingtickets)
	    	pendingticket.setPendingbooking(this);
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

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	
    
}
