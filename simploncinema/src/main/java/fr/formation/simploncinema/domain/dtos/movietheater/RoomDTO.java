package fr.formation.simploncinema.domain.dtos.movietheater;

public class RoomDTO {

    public RoomDTO() {

    }

    private int roomnumber;

    private int numberofrows;

 
    private int numberofseatsbyrow;
    

    private int totalofseats;
    
    private MovieTheaterDTO movietheater;
    
	public int getRoomnumber() {
		return roomnumber;
	}


	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}


	public int getNumberofrows() {
		return numberofrows;
	}


	public void setNumberofrows(int numberofrows) {
		this.numberofrows = numberofrows;
	}


	public MovieTheaterDTO getMovietheater() {
		return movietheater;
	}


	public void setMovietheater(MovieTheaterDTO movietheater) {
		this.movietheater = movietheater;
	}


	public int getNumberofseatsbyrow() {
		return numberofseatsbyrow;
	}


	public void setNumberofseatsbyrow(int numberofseatsbyrow) {
		this.numberofseatsbyrow = numberofseatsbyrow;
	}


	public int getTotalofseats() {
		return totalofseats;
	}


	public void setTotalofseats(int totalofseats) {
		this.totalofseats = totalofseats;
	}


	
    
}
