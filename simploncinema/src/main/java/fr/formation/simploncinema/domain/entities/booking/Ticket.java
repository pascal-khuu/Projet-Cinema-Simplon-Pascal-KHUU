	package fr.formation.simploncinema.domain.entities.booking;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TICKET_ID")
	private long id;
    public Ticket() {

    }
    
    @Column(name = "refticket")
	private long refticket;
    
   @ManyToOne
    @JoinColumn(name="PROJECTIONBOOKING_ID")
    private ProjectionBooking projectionbooking;
    
    
    @Column(name = "rownumber", nullable = false)
    private long rownumber;
    
    @Column(name = "seatnumber", nullable = false)
    private long seatnumber;
    
    
    @Column(name = "isregistered", nullable = false)
    private boolean isregistered;
    
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}




	public ProjectionBooking getProjectionbooking() {
		return projectionbooking;
	}


	public void setProjectionbooking(ProjectionBooking projectionbooking) {
		this.projectionbooking = projectionbooking;
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





	public long getRefticket() {
		return refticket;
	}


	public void setRefticket(long refticket) {
		this.refticket = refticket;
	}


	public boolean isIsregistered() {
		return isregistered;
	}


	public void setIsregistered(boolean isregistered) {
		this.isregistered = isregistered;
	}


	
	
    
    
}
