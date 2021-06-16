package fr.formation.simploncinema.domain.entities.movietheater;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meansofpayment")
public class MeansOfPayment {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEANSOFPAYMENT_ID")
	private long id;
    public MeansOfPayment() {

    }
    @Column(name = "name", nullable = false)
    private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
