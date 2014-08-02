
public class Account {
	private int accountId;
	private int pin;
	private double balance;
	
	public Account(int acct, int p, double balance){
		setAccountId(acct);
		setPin(p);
		setBalance(balance);
	}
	
	public void setAccountId(int acct){
		if (acct < 1000 || acct > 9999){
			System.out.println("Invalid Account Number - Account set to 9999");
			accountId = 9999;
		}
		else{
			accountId = acct;
		}
	}
	
	public void setPin(int p){
		if (p < 1000 || p > 9999){
			System.out.println("Invalid Pin Number - pin set to 9999");
			pin = 9999;
		}
		else{
			pin = p;
		}
	}
	
	public void setBalance(double bal){
		if (bal < 0){
			System.out.println("Invalid Balance - Balance set to 0.0");
			balance = 0;
		}
		else{
			balance = bal;
		}
	}
	
	public double getBalance(){
		return balance;
	}
	
	public int getAccountId(){
		return accountId;
	}
	
	public int getPin(){
		return pin;
	}
	
	public String toString(){
		return "(ID: " + accountId + " Pin: " + pin +
				" Balance: $" + balance + ")";
	}
	
	public boolean equals(Account a){
		return a.pin == pin && a.accountId == accountId;
	}
}
