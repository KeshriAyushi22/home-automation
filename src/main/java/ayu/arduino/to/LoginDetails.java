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
	@JsonProperty("email")
	private String email;
	@JsonProperty("androidId")
	private String androidId;
	@JsonProperty("ln")
	private String loginName;
	@JsonProperty("token")
	private String token;
	@JsonProperty("pass")
	private String password;
	@JsonProperty("house")
	private List<House> house;  //this is holding many values of house so to hold all the values rather than object it is taking list to hold that object.
	
	
	@OneToMany(fetch = FetchType.LAZY ,mappedBy="loginDetails" ,cascade=CascadeType.ALL)  //here mapped by value is the object created in house class for this pojo.
	public List<House> getHouse() {
		return house;
	}
	public void setHouse(List<House> house) {
		this.house = house;
	}
	@Id
	@Column(name = "email", unique = true, nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "androidId", unique = true, length = 10)
	public String getAndroidId() {
		return androidId;
	}
	public void setAndroidId(String androidId) {
		this.androidId = androidId;
	}
	
	@Column(name = "loginName", unique = true, length = 10)
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@Column(name = "token", unique = true, nullable = false, length = 10)
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Column(name = "password", unique = true, nullable = false, length = 10)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
