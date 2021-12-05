package entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String userPassword;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="user_removed")
	private boolean userRemoved;
	
	public User() {
		super();
	}
	public User(String userName, String userPassword, String userType, boolean userRemoved){
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userRemoved = userRemoved;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public boolean isUserRemoved() {
		return userRemoved;
	}
	public void setUserRemoved(boolean userRemoved) {
		this.userRemoved = userRemoved;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userName, userPassword, userRemoved, userType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userName, other.userName) && Objects.equals(userPassword, other.userPassword)
				&& userRemoved == other.userRemoved && Objects.equals(userType, other.userType);
	}
	@Override
	public String toString() {
		return "UserPojo [userName=" + userName + ", userPassword=" + userPassword + ", userType=" + userType
				+ ", userRemoved=" + userRemoved + "]";
	}

}
