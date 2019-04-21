package ayu.arduino.to;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




@Entity
@Table(name = "House_Details", uniqueConstraints = {
@UniqueConstraint(columnNames = "houseId")})
public class House {
	private String address;
	private String houseId;
	//private Set<Rooms> rooms;
	
	private LoginDetails loginDetails;  //here it is having object of each details linked to them by joining one field.
	
	
	
	@Column(name = "address", unique = true, nullable = false, length = 10)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Id
	@Column(name = "houseId", unique = true, nullable = false, length = 10)
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	
	@ManyToOne
	@JoinColumn(name="email")
	@ElementCollection(targetClass=LoginDetails.class)
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}
	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}
	
	/*public Set<Rooms> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Rooms> rooms) {
		this.rooms = rooms;
	}*/
	
	

}
