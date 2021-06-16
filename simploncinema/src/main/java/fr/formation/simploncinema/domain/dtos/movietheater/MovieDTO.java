package fr.formation.simploncinema.domain.dtos.movietheater;


import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


public class MovieDTO {

    public MovieDTO() {

    }

    private String moviename;
    
    private String moviedescription;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm",timezone="Europe/Paris")
    @Temporal(TemporalType.TIME)
    private Date duration;

    private MovieTypeDTO movietype;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    private Date releasedate;

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getMoviedescription() {
		return moviedescription;
	}

	public void setMoviedescription(String description) {
		this.moviedescription = description;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public MovieTypeDTO getMovietype() {
		return movietype;
	}

	public void setMovietype(MovieTypeDTO movietype) {
		this.movietype = movietype;
	}

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

    

}
