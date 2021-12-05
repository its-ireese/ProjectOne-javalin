package entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="empoloyee_details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_first_name")
	private String empFirstName;
	
	@Column(name="emp_last_name")
	private String empLastName;
	
	@Column(name="emp_address")
	private String empAddress;
	
	@Column(name="emp_contact")
	private String empContact;
	
	@Column(name="emp_removed")
	private boolean empRemoved;
	
	Employee(){
		super();
	}
	public Employee(int empId, String empFirstName, String empLastName, String empAddress, String empContact, boolean empRemoved){
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empAddress = empAddress;
		this.empRemoved = empRemoved;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpID(int empId) {
		this.empId = empId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpContact() {
		return empContact;
	}

	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}

	public boolean isEmpRemoved() {
		return empRemoved;
	}

	public void setEmpRemoved(boolean empRemoved) {
		this.empRemoved = empRemoved;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empAddress, empContact, empFirstName, empId, empLastName, empRemoved);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empAddress, other.empAddress) && Objects.equals(empContact, other.empContact)
				&& Objects.equals(empFirstName, other.empFirstName) && empId == other.empId
				&& Objects.equals(empLastName, other.empLastName) && empRemoved == other.empRemoved;
	}

	@Override
	public String toString() {
		return "EmployeePojo [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empAddress=" + empAddress + ", empContact=" + empContact + ", empRemoved=" + empRemoved + "]";
	}

}
