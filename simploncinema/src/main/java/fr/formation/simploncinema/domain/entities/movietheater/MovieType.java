package fr.formation.simploncinema.domain.entities.movietheater;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movietype")
public class MovieType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIETYPE_ID")
    private long id;

    public MovieType() {

    }

    @Column(name = "type")
    private String type;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

}
