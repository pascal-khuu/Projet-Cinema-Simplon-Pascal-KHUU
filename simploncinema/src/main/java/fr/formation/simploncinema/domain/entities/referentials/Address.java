package fr.formation.simploncinema.domain.entities.referentials;

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
@Table(name = "address")
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "ADDRESS_ID")
		private long id;
	    public Address() {

	    }
	    @Column(name = "street_number", nullable = false)
	    private long street_number;

	    @Column(name = "street_type", nullable = false)
	    private String streetype;

		@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
	    @JoinColumn(name="CITY_ID")
	    private City city;

	    @Column(name = "postalcode", nullable = false)
	    private String postalcode;

	    
	    @Column(name = "country", nullable = false)
	    private String country;
	    
	    
	    public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public long getStreet_number() {
			return street_number;
		}


		public void setStreet_number(long street_number) {
			this.street_number = street_number;
		}


		public String getStreetype() {
			return streetype;
		}


		public void setStreetype(String streetype) {
			this.streetype = streetype;
		}


		public City getCity() {
			return city;
		}


		public void setCity(City city) {
			this.city = city;
		}


		public String getPostalcode() {
			return postalcode;
		}


		public void setPostalcode(String postalcode) {
			this.postalcode = postalcode;
		}


		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}


		@Override
		public String toString() {
			return  "Address [street_number=" + street_number + ", streetype=" + streetype + ", city="
					+ city.getCityname() + ", postalcode=" + postalcode + ", country=" + country + "]";
		}
		
}
