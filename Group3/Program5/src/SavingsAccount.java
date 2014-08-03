
public class SavingsAccount extends BankAccount{
	private double interestRate;
	
	public SavingsAccount(int accountNum, String customerName, double balance, double interestRate) {
		super(accountNum, customerName, balance);
		this.interestRate = interestRate;
	}
	
	public SavingsAccount(int accountNum, String customerName, double interestRate) {
		super(accountNum, customerName);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void accureInterest() {
		balance = balance + interestRate * balance;
	}
}
