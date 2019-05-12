package ayu.arduino.to;

import java.util.List;

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
@Table(name = "Room_Details", uniqueConstraints = {
		@UniqueConstraint(columnNames = "roomId")})
public class Rooms {
	@Id
	@Column(name = "roomId",  length = 255)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roomId;
	
	/*@Column(name = "roomName",  length = 255)
	private String roomName;*/

	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="houseName")
	@ElementCollection(targetClass=House.class)
	private House house;

	
	//@JsonIgnore
	@Column(name = "appliance",  length = 255)
	@OneToMany(mappedBy="rooms" ,cascade=CascadeType.ALL)
	private List<Appliance> appliance;


	

	/*public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}*/
	
	public List<Appliance> getAppliance() {
		return appliance;
	}
	public void setAppliance(List<Appliance> appliance) {
		this.appliance = appliance;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}


}
