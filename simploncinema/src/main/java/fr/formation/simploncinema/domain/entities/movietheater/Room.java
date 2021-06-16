package fr.formation.simploncinema.domain.entities.movietheater;

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

@Entity
@Table(name = "room")
public class Room {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROOM_ID")
	private long id;
    public Room() {

    }
    
    @Column(name = "roomnumber", nullable = false)
    private int roomnumber;
    
   
    
    @Column(name = "numberofrows", nullable = false)
    private int numberofrows;
    
    @Column(name = "numberofseatsbyrow", nullable = false)
    private int numberofseatsbyrow;
    
    @Column(name = "totalofseats", nullable = false)
    private int totalofseats;
    
    
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="MOVIETHEATER_ID")
    private MovieTheater movietheater;
 
    
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


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



	public MovieTheater getMovietheater() {
		return movietheater;
	}


	public void setMovietheater(MovieTheater movietheater) {
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
