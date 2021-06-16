package fr.formation.simploncinema.domain.entities.movietheater;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "projection")
public class Projection {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECTION_ID")
	private long id;
    public Projection() {

    }
    
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="MOVIETHEATER_ID")
    private MovieTheater movieTheater;
    
    
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="ROOM_ID")
    private Room room;
    
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="MOVIE_ID")
    private Movie movie;
    
    @Column(name = "version", nullable = false)
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
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MovieTheater getMovieTheater() {
		return movieTheater;
	}

	public void setMovieTheater(MovieTheater movieTheater) {
		this.movieTheater = movieTheater;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
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
