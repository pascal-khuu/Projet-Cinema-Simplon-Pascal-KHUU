package fr.formation.simploncinema.domain.dtos.booking;


public class TicketDTO {

    public TicketDTO() {

    }

    private ProjectionBookingDTO projectionbooking;
    
	private long refticket;
    
    private long rownumber;

    private long seatnumber;
    
    private boolean isregistered;


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





	public ProjectionBookingDTO getProjectionbooking() {
		return projectionbooking;
	}


	public void setProjectionbooking(ProjectionBookingDTO projectionbooking) {
		this.projectionbooking = projectionbooking;
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
