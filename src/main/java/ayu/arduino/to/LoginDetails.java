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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;




@Entity
@Table(name = "Login_Details", uniqueConstraints = {
		@UniqueConstraint(columnNames = "android_id"),
		@UniqueConstraint(columnNames = "email"),@UniqueConstraint(columnNames = "user_id") })
public class LoginDetails {



	@Id
	@JsonProperty("email")
	@Column(name = "email", unique = true, nullable = false,length = 255)
	private String email;

	@JsonProperty("userId")
	@Column(name = "user_id", unique = true, length = 255)
	private String userId;



	@JsonProperty("androidId")
	@Column(name = "android_id", unique = true, length = 255)
	private String androidId;


	@JsonProperty("loginName")
	@Column(name = "loginName", length = 255)
	private String loginName;

	@JsonProperty("NotificationToken")
	@Column(name = "notification_token", unique = true, length = 255)
	private String NotificationToken;


	@JsonProperty("password")
	@Column(name = "password", unique = true,  length = 255)
	private String password;

	@JsonProperty("newPassword")
	@Column(name = "new_password", unique = true, length = 255)
	private String NewPassword;

	@JsonProperty("passwordToken")
	@Column(name = "password_token", unique = true, length = 255)
	private String passwordToken;


	@OneToMany(mappedBy="loginDetails" ,cascade=CascadeType.ALL)
	//here mapped by value is the object created in house class for this pojo.
	@JsonProperty("house")
	private List<House> house;  //this is holding many values of house so to hold all the values rather than object it is taking list to hold that object.

	@JsonProperty("isActive")
	@Column(name = "isActive", length = 255)
	private boolean isActive;

	@JsonProperty("type")
	@Column(name = "type",  length = 255)
	private String type;

	@JsonIgnore
	@OneToOne(mappedBy ="loginDetail")
	private Mail mail;




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
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




	public String getNotificationToken() {
		return NotificationToken;
	}




	public void setNotificationToken(String notificationToken) {
		NotificationToken = notificationToken;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getNewPassword() {
		return NewPassword;
	}




	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}




	public String getPasswordToken() {
		return passwordToken;
	}




	public void setPasswordToken(String passwordToken) {
		this.passwordToken = passwordToken;
	}




	public List<House> getHouse() {
		return house;
	}




	public void setHouse(List<House> house) {
		this.house = house;
	}




	public boolean isActive() {
		return isActive;
	}




	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public Mail getMail() {
		return mail;
	}




	public void setMail(Mail mail) {
		this.mail = mail;
	}




	public LoginDetails() {
		//by default the email is active.
		this.isActive=true;
		this.passwordToken="noToken";

	}





}
