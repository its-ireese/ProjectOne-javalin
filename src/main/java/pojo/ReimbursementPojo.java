package pojo;

import java.util.Objects;

public class ReimbursementPojo {
	private int reimId;
	private int reimEmpId;
	private int reimAmount;
	private boolean reimStatus;
	private boolean reimApproved;
	
	public ReimbursementPojo() {
		super();
	}
	
	public ReimbursementPojo(int reimId, int reimEmpId, int reimAmount, boolean reimStatus, boolean reimApproved){
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
	public int hashCode() {
		return Objects.hash(reimAmount, reimApproved, reimEmpId, reimId, reimStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementPojo other = (ReimbursementPojo) obj;
		return reimAmount == other.reimAmount && reimApproved == other.reimApproved && reimEmpId == other.reimEmpId
				&& reimId == other.reimId && reimStatus == other.reimStatus;
	}

	@Override
	public String toString() {
		return "ReimbursementPojo [reimId=" + reimId + ", reimEmpId=" + reimEmpId + ", reimAmount=" + reimAmount
				+ ", reimStatus=" + reimStatus + ", reimApproved=" + reimApproved + "]";
	}
	
		
}