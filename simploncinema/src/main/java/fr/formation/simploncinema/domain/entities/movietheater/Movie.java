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
@Table(name = "movie")
public class Movie {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIE_ID")
	private long id;
    public Movie() {

    }
    
    
    @Column(name = "moviename", nullable = false)
    private String moviename;
    
    
    @Column(name = "moviedescription", nullable = false)
    private String moviedescription;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm",timezone="Europe/Paris")
    @Temporal(TemporalType.TIME)
    @Column(name = "duration", nullable = false)
    private Date duration;
    
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="MOVIETYPE_ID")
    private MovieType movietype;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    @Column(name="releasedate")
    private Date releasedate;
    
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public MovieType getMovietype() {
		return movietype;
	}

	public void setMovietype(MovieType movietype) {
		this.movietype = movietype;
	}

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

    

}
