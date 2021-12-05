package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="reimbursement_details")
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="reim_id")
	private int reimId;
	

	@Column(name="emp_id")
	private int reimEmpId;
			

	@Column(name="reim_amount")
	private int reimAmount;
		

	@Column(name="reim_status")
	private boolean reimStatus;
	
	@Column(name="reim_approved")
	private boolean reimApproved;
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int reimId, int reimEmpId, int reimAmount, boolean reimStatus, boolean reimApproved) {
		super();
		this.reimId = reimId;
		this.reimEmpId = reimEmpId;
		this.reimAmount = reimAmount;
		this.reimStatus = reimStatus;
		this.reimApproved = reimApproved;
	}


	public int getReimId() {
		return reimId;
	}

	public void setReimId(int reimId) {
		this.reimId = reimId;
	}

	public int getReimEmpId() {
		return reimEmpId;
	}

	public void setReimEmpId(int reimEmpId) {
		this.reimEmpId = reimEmpId;
	}

	public int getReimAmount() {
		return reimAmount;
	}

	public void setReimAmount(int reimAmount) {
		this.reimAmount = reimAmount;
	}

	public boolean isReimStatus() {
		return reimStatus;
	}

	public void setReimStatus(boolean reimStatus) {
		this.reimStatus = reimStatus;
	}
	
	public boolean isReimApproved() {
		return reimApproved;
	}
	
	public void setReimApproved(boolean reimApproved) {
		this.reimApproved = reimApproved;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimId=" + reimId + ", reimEmpId=" + reimEmpId + ", reimAmount=" + reimAmount
				+ ", reimStatus=" + reimStatus + ", reimApproved=" + reimApproved + "]";
	}
	
}
