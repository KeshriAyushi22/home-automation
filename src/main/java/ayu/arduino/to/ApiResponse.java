package ayu.arduino.to;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ApiResponse {
	private String resStatus;
	private String resCode;
	private String errorStatus;
	private String errorCode;
	private List<House> house;
	private List<Appliance> appliance;
	private List<Rooms> rooms;
	
	
	
	public List<Appliance> getAppliance() {
		return appliance;
	}
	public void setAppliance(List<Appliance> appliance) {
		this.appliance = appliance;
	}
	public List<Rooms> getRooms() {
		return rooms;
	}
	public void setRooms(List<Rooms> rooms) {
		this.rooms = rooms;
	}
	public List<House> getHouse() {
		return house;
	}
	public void setHouse(List<House> house) {
		this.house = house;
	}
	public String getResStatus() {
		return resStatus;
	}
	public void setResStatus(String resStatus) {
		this.resStatus = resStatus;
	}
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getErrorStatus() {
		return errorStatus;
	}
	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	 

}
