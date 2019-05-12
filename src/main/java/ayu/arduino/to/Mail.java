package ayu.arduino.to;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "Activation", uniqueConstraints = {
@UniqueConstraint(columnNames = "email") })
public class Mail {

	
	
	@JsonIgnore
	@OneToOne( cascade=CascadeType.ALL)
	@JoinColumn(name="email")
	@ElementCollection(targetClass=LoginDetails.class)
	private LoginDetails loginDetail;
	
	@JsonProperty("hash")
	@Column(name = "hash", length = 255)
	private String hash;
	
	@JsonProperty("active")
	@Column(name = "active",length = 255)
	private String active;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mId", unique = true, nullable = false)
	private int mId;

	
	
	

	public String getHash() {
		return hash;
	}
	public LoginDetails getLoginDetail() {
		return loginDetail;
	}
	public void setLoginDetail(LoginDetails loginDetail) {
		this.loginDetail = loginDetail;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}
	public Mail() {
		super();
		this.active="pending";
		// TODO Auto-generated constructor stub
	}




}
