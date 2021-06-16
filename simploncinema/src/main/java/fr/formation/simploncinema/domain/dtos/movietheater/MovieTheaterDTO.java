package fr.formation.simploncinema.domain.dtos.movietheater;


import fr.formation.simploncinema.validation.UniqueMovieTheater;

public class MovieTheaterDTO {

    
    public MovieTheaterDTO() {

    }

    @UniqueMovieTheater
    private String movietheatername;

    private Long addressId;


	public String getMovietheatername() {
		return movietheatername;
	}



	public void setMovietheatername(String movietheatername) {
		this.movietheatername = movietheatername;
	}



	public Long getAddressId() {
	    return addressId;
	}



	public void setAddressId(Long addressId) {
	    this.addressId = addressId;
	}



	


	


    
    

    
    
}
