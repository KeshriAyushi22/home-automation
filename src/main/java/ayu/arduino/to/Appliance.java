package ayu.arduino.to;

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

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "Appliance_Details", uniqueConstraints = {
		@UniqueConstraint(columnNames = "app_id")})
public class Appliance {
	
	@Id
	@Column(name = "app_id",  length = 255)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int appId;

	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="room_id")
	@ElementCollection(targetClass=Rooms.class)
	private Rooms rooms;

	@Column(name = "lights",  length = 255)
	private String lights;

	@Column(name = "fan",  length = 255)
	private String fan;

	@Column(name = "plug",  length = 255)
	private String plug;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public Rooms getRooms() {
		return rooms;
	}

	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}

	public String getLights() {
		return lights;
	}

	public void setLights(String lights) {
		this.lights = lights;
	}

	public String getFan() {
		return fan;
	}

	public void setFan(String fan) {
		this.fan = fan;
	}

	public String getPlug() {
		return plug;
	}

	public void setPlug(String plug) {
		this.plug = plug;
	}
	
	
	
}
