package ayu.arduino.to;

import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
public class VerifyTokenConfirmationMail {

	//thisis for the token created to confirm your mail id will be till 24 hrs valid after that it expires.
	
	    private static final int EXPIRATION = 60 * 24;
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    
	    @JsonProperty("token")
		@Column(name = "token",length = 255)
	    private String token;
	   
	    @OneToOne(targetEntity = LoginDetails.class, fetch = FetchType.EAGER)
	    @JoinColumn(nullable = false, name = "email")
	    private LoginDetails loginDetail;
	     
	    @JsonProperty("expiryDate")
		@Column(name = "expiryDate",length = 255)
	    private Date expiryDate;
	    
	    private Date calculateExpiryDate(int expiryTimeInMinutes) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date(cal.getTime().getTime()));
	        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
	        return new Date(cal.getTime().getTime());
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public LoginDetails getLoginDetail() {
			return loginDetail;
		}

		public void setLoginDetail(LoginDetails loginDetail) {
			this.loginDetail = loginDetail;
		}

		public Date getExpiryDate() {
			return expiryDate;
		}

		public void setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate;
		}

		public static int getExpiration() {
			return EXPIRATION;
		}

		public VerifyTokenConfirmationMail(Long id, String token, LoginDetails loginDetail, Date expiryDate) {
			super();
			this.id = id;
			this.token = token;
			this.loginDetail = loginDetail;
			this.expiryDate = expiryDate;
		}

		public VerifyTokenConfirmationMail() {
			super();
			// TODO Auto-generated constructor stub
		}
	     
	    // standard constructors, getters and setters
	    
	}

