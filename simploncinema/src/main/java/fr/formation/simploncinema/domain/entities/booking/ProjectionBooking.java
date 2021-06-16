package fr.formation.simploncinema.domain.entities.booking;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import fr.formation.simploncinema.domain.entities.movietheater.Projection;

@Entity
@Table(name = "projectionbooking")
public class ProjectionBooking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECTIONBOOKING_ID")
	private long id;
    public ProjectionBooking() {

    }
    
    @Column(name = "refprojectionbooking")
	private long refprojectionbooking;
    
    @OneToOne( cascade = CascadeType.ALL,fetch=FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name="PROJECTION_ID")
    private Projection projection;
    
    
    @OneToMany(mappedBy = "projectionbooking",  cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    
    private List<Ticket> tickets=new ArrayList<Ticket>();
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets.addAll(tickets);
		  for (Ticket ticket: tickets)
			  ticket.setProjectionbooking(this);

		
		
	}

	
	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	public long getRefprojectionbooking() {
		return refprojectionbooking;
	}

	public void setRefprojectionbooking(long refprojectionbooking) {
		this.refprojectionbooking = refprojectionbooking;
	}

	

  

    
}
