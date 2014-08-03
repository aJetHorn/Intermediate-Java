public class Program5 {
	public static void main(String[] args) {
		Bank bank = new Bank("The Small Bank");
		
		bank.addAccount(42001, "John Gutfreund", 85234.12, 0.001);
		bank.addAccount(42002, "Michael Burry", 12.83, 0.0005);
		bank.addAccount(42003, "Barry Minkow", 85234.12, 0.0008);
		
		bank.printBankSummary();
		bank.accrueInterestAllAccounts();
		bank.printBankSummary();
	}
}
