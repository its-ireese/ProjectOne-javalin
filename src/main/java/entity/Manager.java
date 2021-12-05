package entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="manager_details")
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="mgr_id")
	private int mgrId;
	
	@Column(name="mgr_first_name")
	private String mgrFirstName;
	
	@Column(name="mgr_last_name")
	private String mgrLastName;
	
	@Column(name="mgr_address")
	private String mgrAddress;
	
	@Column(name="mgr_contact")
	private String mgrContact;
	
	@Column(name="mgr_removed")
	private boolean mgrRemoved;
	
	Manager(){
		super();
	}
	
	public Manager(int mgrId, String mgrFirstName, String mgrLastName, String mgrAddress, String mgrContact, boolean mgrRemoved){
		super();
		this.mgrId = mgrId;
		this.mgrFirstName = mgrFirstName;
		this.mgrLastName = mgrLastName;
		this.mgrAddress = mgrAddress;
		this.mgrRemoved = mgrRemoved;
	}

	public int getMgrId() {
		return mgrId;
	}

	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}

	public String getMgrFirstName() {
		return mgrFirstName;
	}

	public void setMgrFirstName(String mgrFirstName) {
		this.mgrFirstName = mgrFirstName;
	}

	public String getMgrLastName() {
		return mgrLastName;
	}

	public void setMgrLastName(String mgrLastName) {
		this.mgrLastName = mgrLastName;
	}

	public String getMgrAddress() {
		return mgrAddress;
	}

	public void setMgrAddress(String mgrAddress) {
		this.mgrAddress = mgrAddress;
	}

	public String getMgrContact() {
		return mgrContact;
	}

	public void setMgrContact(String mgrContact) {
		this.mgrContact = mgrContact;
	}

	public boolean isMgrRemoved() {
		return mgrRemoved;
	}

	public void setMgrRemoved(boolean mgrRemoved) {
		this.mgrRemoved = mgrRemoved;
	}


	@Override
	public int hashCode() {
		return Objects.hash(mgrAddress, mgrContact, mgrFirstName, mgrId, mgrLastName, mgrRemoved);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return Objects.equals(mgrAddress, other.mgrAddress) && Objects.equals(mgrContact, other.mgrContact)
				&& Objects.equals(mgrFirstName, other.mgrFirstName) && mgrId == other.mgrId
				&& Objects.equals(mgrLastName, other.mgrLastName) && mgrRemoved == other.mgrRemoved;
	}

	@Override
	public String toString() {
		return "ManagerPojo [mgrId=" + mgrId + ", mgrFirstName=" + mgrFirstName + ", mgrLastName=" + mgrLastName
				+ ", mgrAddress=" + mgrAddress + ", mgrContact=" + mgrContact + ", mgrRemoved=" + mgrRemoved + "]";
	}


}
