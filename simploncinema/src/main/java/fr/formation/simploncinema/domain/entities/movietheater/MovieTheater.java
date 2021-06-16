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

import fr.formation.simploncinema.domain.entities.referentials.Address;

@Entity
@Table(name = "movietheater")
public class MovieTheater {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIETHEATER_ID")
	private long id;
    
    
    public MovieTheater() {

    }
    @Column(name = "movietheatername", nullable = false)
    private String movietheatername;

    
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST )
    @JoinColumn(name="ADDRESS_ID")
    private Address address;
    
    

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getMovietheatername() {
		return movietheatername;
	}



	public void setMovietheatername(String movietheatername) {
		this.movietheatername = movietheatername;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}

    
    
}
