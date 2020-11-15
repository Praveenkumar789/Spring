import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="Insurance")
public class Insurance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int policyNo;
	private String name;
	private int tenure;
	private int amount;
	
	Insurance(){}
	Insurance(int pno, String name, int tenure, int amt){
		this.policyNo = pno;
		this.name = name;
		this.tenure = tenure;
		this.amount = amt;
	}
	
	public int getPolicyNo() {
		return policyNo;
	}
	
	public void setPolicyNo(int PolicyNo) {
		this.policyNo = PolicyNo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String Name) {
		this.name = Name;
	}
	
	public int getTenure() {
		return tenure;
	}
	
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amt) {
		this.amount = amt;
	}
	
	
}
