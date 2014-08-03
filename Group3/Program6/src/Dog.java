import java.text.SimpleDateFormat;
import java.util.Date;

public class Dog extends Pet implements Vaccinatable{
	private boolean fixed;
	private Date vaccineDate;

	public Dog(String name, String owner, double weight, Date vaccineDate) {
		this(name, owner, weight, vaccineDate, false);
	}

	public Dog(String name, String owner, double weight, Date vaccineDate, boolean fixed) {
		super(name, owner, weight);
		this.vaccineDate = vaccineDate;
		this.fixed = fixed;
	}

	public String getSize() {
		if (weight > 50) {
			return "Large";
		} else if (weight < 30) {
			return "Small";
		} else {
			return "Medium";
		}
	}

	public Date getVaccineDate() {
		return vaccineDate;
	}

	public void setVaccineDate(Date vaccineDate) {
		this.vaccineDate = vaccineDate;
	}
	
	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}
	
	public String toString() {
		SimpleDateFormat stdDate = new SimpleDateFormat("MM/dd/yy");
		if (!fixed) {
			return name + " owned by " + owner + ": " + getSize() + " Dog, " + weight + " lbs, not fixed, last vaccine: " + stdDate.format(vaccineDate);	
		} else{
			return name + " owned by " + owner + ": " + getSize() + " Dog, " + weight + " lbs, last vaccine: " + stdDate.format(vaccineDate);	
		}
	}
}
