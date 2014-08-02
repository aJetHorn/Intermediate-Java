
public class Program5 {
	  public static void main(String[]args){
		    AccountDatabase database = new AccountDatabase();
		    database.readTransaction("Transactions.txt");
		    database.printTransactions();
		    database.backUpDatabase("output.txt");
		   database.recoverBackUp("output.txt");
		   database.printTransactions();
		   Transaction tran = database.findTrans(8901);
		   System.out.println(tran);
		    } 
}
