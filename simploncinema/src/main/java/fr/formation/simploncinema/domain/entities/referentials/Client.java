package fr.formation.simploncinema.domain.entities.referentials;

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
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENT_ID")
    private long id;
    public Client() {

    }
    
    @Column(name = "refclient")
    private long refclient;
    
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    
    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "password", nullable = false)
    private String password;

    
    @Column(name = "gender", nullable = false)
    private String gender;
	
    @Column(name = "mobilephone", nullable = false)
    private String mobilephone;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate", nullable = false)
    private Date birthdate;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",timezone="Europe/Paris")
    @Temporal(TemporalType.DATE)
    @Column(name = "subscriptiondate", nullable = false)
    private Date subscriptiondate;
    
   
    @Column(name = "mailmessage", nullable = false)
    private String mailmessage;
    
    
    @Column(name = "notificationmessage", nullable = false)
    private String notificationmessage;

    
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="ADDRESS_ID")
    private Address address;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
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


	public String getMobilephone() {
		return mobilephone;
	}


	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
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
		return "Client [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", mail=" + mail
				+ ", password=" + password + ", gender=" + gender + ", mobilephone=" + mobilephone + ", birthdate="
				+ birthdate + ", subscriptiondate=" + subscriptiondate + ", mailmessage=" + mailmessage
				+ ", notificationmessage=" + notificationmessage + "]";
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public long getRefclient() {
		return refclient;
	}


	public void setRefclient(long refclient) {
		this.refclient = refclient;
	}

	
	 

    
}
