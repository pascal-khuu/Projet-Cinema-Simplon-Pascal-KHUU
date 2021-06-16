package fr.formation.simploncinema.domain.entities.referentials;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CITY_ID")
    private long id;
    public City() {

    }
    @Column(name = "city_name", nullable = false)
    private String cityname;
    
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
}
