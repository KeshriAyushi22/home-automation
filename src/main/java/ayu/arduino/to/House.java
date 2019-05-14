package ayu.arduino.to;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "House_Details", uniqueConstraints = {
@UniqueConstraint(columnNames = "house_id")})
public class House {
	private String address;
	private int houseId;
	private String houseName;
	private List<Rooms> rooms;
	private LoginDetails loginDetails; //here it is having object of each details linked to them by joining one field.
	
	
	@Column(name = "address", nullable = false, length = 255)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Id
	@Column(name = "house_id", unique = true, nullable = false, length = 255 )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name="email")
	@ElementCollection(targetClass=LoginDetails.class)
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}
	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}
	
	@OneToMany(mappedBy="house" ,cascade=CascadeType.ALL) 
	public List<Rooms> getRooms() {
		return rooms;
	}
	public void setRooms(List<Rooms> rooms) {
		this.rooms = rooms;
	}
	
	@Column(name = "house_name", nullable = false, length = 255)
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	
	
	

}
