package ayu.arduino.to;

import java.util.List;
import java.util.Set;
import javax.persistence.UniqueConstraint;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;




@Entity
@Table(name = "Login_Details", uniqueConstraints = {
@UniqueConstraint(columnNames = "androidId"),
@UniqueConstraint(columnNames = "email") })
public class LoginDetails {
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loginId", unique = true, nullable = false)
	private int loginId;*/
	
	@Id
	@JsonProperty("email")
	@Column(name = "email", unique = true, nullable = false,length = 255)
	private String email;
	
	
	@JsonProperty("androidId")
	@Column(name = "androidId", unique = true, length = 255)
	private String androidId;
	
	
	@JsonProperty("ln")
	@Column(name = "loginName", unique = true, length = 255)
	private String loginName;
	
	@JsonProperty("token")
	@Column(name = "token", unique = true, nullable = false, length = 255)
	private String token;
	
	
	@JsonProperty("pass")
	@Column(name = "password", unique = true, nullable = false, length = 255)
	private String password;
	
	@OneToMany(mappedBy="loginDetails" ,cascade=CascadeType.ALL)  //here mapped by value is the object created in house class for this pojo.
	@JsonProperty("house")
	private List<House> house;  //this is holding many values of house so to hold all the values rather than object it is taking list to hold that object.
	
	@JsonProperty("isActive")
	@Column(name = "isActive", unique = true, nullable = false, length = 255)
	private String isActive;
	
	
	public List<House> getHouse() {
		return house;
	}
	public void setHouse(List<House> house) {
		this.house = house;
	}

	
	
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getAndroidId() {
		return androidId;
	}
	public void setAndroidId(String androidId) {
		this.androidId = androidId;
	}
	
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
