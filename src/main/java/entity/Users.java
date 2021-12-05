package entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="users_details")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="user_id")
	private int userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String userPassword;

	@Column(name="usertype")
	private String userType;

	@Column(name="user_first_name")
	private String userFirstName;
	
	@Column(name="user_last_name")
	private String userLastName;
	
	@Column(name="user_address")
	private String userAddress;
	
	@Column(name="user_contact")
	private String userContact;
	
	@Column(name="user_removed")
	private boolean userRemoved;
	
	public Users() {
		super();
	}
	public Users(int userId, String userName, String userPassword, String userType, String userFirstName, String userLastName, String userAddress, String userContact,  boolean userRemoved){
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAddress = userAddress;
		this.userContact = userContact;
		this.userRemoved = userRemoved;
}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public boolean isUserRemoved() {
		return userRemoved;
	}
	public void setUserRemoved(boolean userRemoved) {
		this.userRemoved = userRemoved;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userAddress, userContact, userFirstName, userId, userLastName, userName, userPassword,
				userRemoved, userType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(userAddress, other.userAddress) && Objects.equals(userContact, other.userContact)
				&& Objects.equals(userFirstName, other.userFirstName) && userId == other.userId
				&& Objects.equals(userLastName, other.userLastName) && Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword) && userRemoved == other.userRemoved
				&& Objects.equals(userType, other.userType);
	}
	@Override
	public String toString() {
		return "UsersPojo [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userType=" + userType + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userAddress=" + userAddress + ", userContact=" + userContact + ", userRemoved=" + userRemoved
				+ "]";
	}
	
}

