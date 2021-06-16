package fr.formation.simploncinema.domain.dtos.referentials;


public class AddressDTO {
 

	    public AddressDTO() {

	    }
	 
	    private long street_number;

	    private String streetype;


	    private CityDTO city;


	    private String postalcode;


	    private String country;
	    


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


		public CityDTO getCity() {
			return city;
		}


		public void setCity(CityDTO city) {
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
			return "Address [street_number=" + street_number + ", streetype=" + streetype + ", city="
					+ city.getCityname() + ", postalcode=" + postalcode + ", country=" + country + "]";
		}
	
		
}
