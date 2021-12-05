package entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="shoes_details")
public class Shoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="shoe_id")
	private int shoeId;
	
	@Column(name="shoe_name")
	private String shoeName;
	
	@Column(name="shoe_brand")
	private String shoeBrand;
	
	@Column(name="shoe_cost")
	private int shoeCost;
	
	@Column(name="shoe_available")
	private boolean shoeAvailable;
	
	public Shoes() {
		super();
	}
	public Shoes(int shoeId, String shoeName, String shoeBrand, int shoeCost, boolean shoeAvailable) {
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
	public int hashCode() {
		return Objects.hash(shoeAvailable, shoeBrand, shoeCost, shoeId, shoeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shoes other = (Shoes) obj;
		return shoeAvailable == other.shoeAvailable && Objects.equals(shoeBrand, other.shoeBrand)
				&& shoeCost == other.shoeCost && shoeId == other.shoeId && Objects.equals(shoeName, other.shoeName);
	}

	@Override
	public String toString() {
		return "Shoes [shoeId=" + shoeId + ", shoeName=" + shoeName + ", shoeBrand=" + shoeBrand + ", shoeCost="
				+ shoeCost + ", shoeAvailable=" + shoeAvailable + "]";
	}
	
}
