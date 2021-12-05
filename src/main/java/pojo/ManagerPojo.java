package pojo;

import java.util.Objects;

public class ManagerPojo {
	private int mgrId;
	private String mgrFirstName;
	private String mgrLastName;
	private String mgrAddress;
	private String mgrContact;
	private boolean mgrRemoved;
	
	ManagerPojo(){
		super();
	}
	
	public ManagerPojo(int mgrId, String mgrFirstName, String mgrLastName, String mgrAddress, String mgrContact, boolean mgrRemoved){
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
		ManagerPojo other = (ManagerPojo) obj;
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
