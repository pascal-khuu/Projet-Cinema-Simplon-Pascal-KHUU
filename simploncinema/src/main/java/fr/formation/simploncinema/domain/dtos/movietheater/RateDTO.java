package fr.formation.simploncinema.domain.dtos.movietheater;



public class RateDTO {


    public RateDTO() {

    }
    

    private String type;
	

    private double price;

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

}
