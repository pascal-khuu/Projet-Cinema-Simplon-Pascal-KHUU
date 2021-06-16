package fr.formation.simploncinema.domain.dtos.movietheater;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjectionDTO {

    public ProjectionDTO() {

    }
    

    private MovieTheaterDTO movieTheater;

    private RoomDTO room;

    private MovieDTO movie;

    private String version;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    private Date projectiondate;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm",timezone="Europe/Paris")
    @Temporal(TemporalType.TIME)
    private Date starthour;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm",timezone="Europe/Paris")
    @Temporal(TemporalType.TIME)
    private Date endhour;



	public MovieTheaterDTO getMovieTheater() {
		return movieTheater;
	}

	public void setMovieTheater(MovieTheaterDTO movieTheater) {
		this.movieTheater = movieTheater;
	}

	public RoomDTO getRoom() {
		return room;
	}

	public void setRoom(RoomDTO room) {
		this.room = room;
	}

	public MovieDTO getMovie() {
		return movie;
	}

	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getProjectiondate() {
		return projectiondate;
	}

	public void setProjectiondate(Date projectiondate) {
		this.projectiondate = projectiondate;
	}

	public Date getStarthour() {
		return starthour;
	}

	public void setStarthour(Date starthour) {
		this.starthour = starthour;
	}

	public Date getEndhour() {
		return endhour;
	}

	public void setEndhour(Date endhour) {
		this.endhour = endhour;
	}

    
}
