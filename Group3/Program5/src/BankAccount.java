public class BankAccount {
	int accountNum;
	String customerName;
	double balance;
	
	public BankAccount(int accountNum, String customerName, double balance) {
		this.accountNum = accountNum;
		this.customerName = customerName;
		this.balance = balance;
	}
	
	public BankAccount(int accountNum, String customerName) {
		this(accountNum, customerName, 0);
	}
	
	public int getAccountNum() {
		return accountNum;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void makeDeposit(double depositAmt) {
		balance = balance + depositAmt;
	}
	
	public void printAccountInfo() {
		System.out.printf("%-5d %-15s %5.2f\n", accountNum, customerName, balance);
	}
	
}
