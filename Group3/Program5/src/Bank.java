public class Bank {
	private String name;
	private SavingsAccount[] accounts;
	private int totalAccounts;
	public static final int MAX_ACCOUNTS = 20;
	
	public Bank(String name) {
		this.name = name;
		totalAccounts = 0;
		accounts = new SavingsAccount[Bank.MAX_ACCOUNTS];
	}
	
	public String getName() {
		return name;
	}
	
	public void addAccount(int accountNum, String customerName, double balance, double interestRate) {
		accounts[totalAccounts] = new SavingsAccount(accountNum, customerName, balance, interestRate);
		totalAccounts++;
	}
	
	public void printBankSummary() {
		System.out.println("Bank Name: " + name);
		for (int i = 0; i < totalAccounts; i++) {
			accounts[i].printAccountInfo();
		}
		System.out.println();
	}
	
	public void accrueInterestAllAccounts() {
		for (int i = 0; i < totalAccounts; i++) {
			accounts[i].accureInterest();
		}
	}
}
