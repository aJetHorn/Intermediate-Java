
public class Tenant {
	private String firstName;
	private String lastName;
	private String aptNumber;
	private int yearlyRent;
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getAptNumber(){
		return aptNumber;
	}
	
	public void setAptNumber(String aptNumber){
		this.aptNumber = aptNumber;
	}
	
	public int getYearlyRent(){
		return yearlyRent;
	}
	
	public void setYearlyRent(int yearlyRent){
		this.yearlyRent = yearlyRent;
	}
	
	public Tenant(String first, String last, String apt, int rent){
		setFirstName(first);
		setLastName(last);
		setAptNumber(apt);
		setYearlyRent(rent);
	}
	
	public double firstPayment(){
		double monthlyRent = getYearlyRent() / 12;
		return monthlyRent * 3;
	}
	
	public double monthlyPayment(){
		return (getYearlyRent() - (getYearlyRent()/6)) / 11;
	}
	
	public String fullName(){
		return getFirstName() + " " + getLastName();
	}
}
