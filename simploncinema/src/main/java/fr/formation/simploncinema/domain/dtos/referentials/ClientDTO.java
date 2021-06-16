package fr.formation.simploncinema.domain.dtos.referentials;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClientDTO{



    private String lastname;
    private String firstname;
    private long refclient;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    
    
    private String password;

    
    private String gender;
    
    private String mail;
    private String mailmessage;
    private String mobilephone;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    private Date subscriptiondate;
    
    private String notificationmessage;

    private  AddressDTO address;
    
    public ClientDTO() {
    	
    }
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}
	
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}
	
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getSubscriptiondate() {
		return subscriptiondate;
	}

	public void setSubscriptiondate(Date subscriptiondate) {
		this.subscriptiondate = subscriptiondate;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMailmessage() {
		return mailmessage;
	}

	public void setMailmessage(String mailmessage) {
		this.mailmessage = mailmessage;
	}

	public String getNotificationmessage() {
		return notificationmessage;
	}

	public void setNotificationmessage(String notificationmessage) {
		this.notificationmessage = notificationmessage;
	}
	@Override
	public String toString() {
		return "ClientDTO [lastname=" + lastname + ", firstname=" + firstname + ", birthdate=" + birthdate
				+ ", password=" + password + ", gender=" + gender + ", mail=" + mail + ", mailmessage=" + mailmessage
				+ ", mobilephone=" + mobilephone + ", subscriptiondate=" + subscriptiondate + ", notificationmessage="
				+ notificationmessage + "]";
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public long getRefclient() {
		return refclient;
	}
	public void setRefclient(long refclient) {
		this.refclient = refclient;
	}


    

}
