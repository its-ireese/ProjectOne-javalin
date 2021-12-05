package pojo;

public class ShoePojo {
	
	private int shoeId;
	private String shoeName;
	private String shoeBrand;
	private int shoeCost;
	private boolean shoeAvailable;
	
	public ShoePojo() {
		super();
		
	}
	
	public ShoePojo(int shoeId, String shoeName, String shoeBrand, int shoeCost, boolean shoeAvailable) {
		super();
		
		this.shoeId =shoeId;
		this.shoeName = shoeName;
		this.shoeBrand=shoeBrand;
		this.shoeCost = shoeCost;
		this.shoeAvailable = shoeAvailable;
		
	}

	public int getShoeId() {
		return shoeId;
	}

	public void setShoeId(int shoeId) {
		this.shoeId = shoeId;
	}

	public String getShoeName() {
		return shoeName;
	}

	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}

	public String getShoeBrand() {
		return shoeBrand;
	}

	public void setShoeBrand(String shoeBrand) {
		this.shoeBrand = shoeBrand;
	}

	public int getShoeCost() {
		return shoeCost;
	}

	public void setShoeCost(int shoeCost) {
		this.shoeCost = shoeCost;
	}

	public boolean isShoeAvailable() {
		return shoeAvailable;
	}

	public void setShoeAvailable(boolean shoeAvailable) {
		this.shoeAvailable = shoeAvailable;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoePojo other = (ShoePojo) obj;
		if (shoeBrand == null) {
			if (other.shoeBrand != null)
				return false;
		} else if (!shoeBrand.equals(other.shoeBrand))
			return false;
		if (shoeCost != other.shoeCost)
			return false;
		if (shoeId != other.shoeId)
			return false;
		if (shoeAvailable != other.shoeAvailable)
			return false;
		if (shoeName == null) {
			if (other.shoeName != null)
				return false;
		} else if (!shoeName.equals(other.shoeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoePojo [shoeId=" + shoeId + ", shoeName=" + shoeName + ", shoeBrand=" + shoeBrand + "shoeCost=" + shoeCost + "shoeAvailable=" + shoeAvailable + "]";
	}

}
