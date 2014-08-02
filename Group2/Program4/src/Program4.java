
public class Program4 {
	public static void main(String [] args){
	    Transaction tran10 = new Transaction(1234, 4321, 1000.75, 5432, 1);
	    Transaction tran20 = new Transaction(1234, 4321, 1000.75, 5432, 2);
	    tran10.setAccountId(2345);
	    tran20.setAccountId(12345);
	    tran20.setTransNum(2000);
	    tran10.setTransType(2);
	    System.out.println("Trans 10:" + tran10);
	    System.out.println("Trans 20:" + tran20);
	    System.out.println("Trans 20:(Account Id: " +
	                         + tran20.getAccountId() + " TransNum: " 
	                         + tran20.getTransNum()  + " TransType: "
	                         + tran20.getTransType() + " )" );
	    System.out.println(tran10.equals(tran20));
	    if(tran20.compareTo(tran10) > 0)
	      System.out.println("tran20 Account id or TransNum is greater than Tran10");
	    else if (tran20.compareTo(tran10) > 0)
	      System.out.println("tran20 Account id or TransNum is less than Tran10");
	    else
	      System.out.println("tran20 and tran 10 have the same Accountid and TransNum");
	      
	    Withdrawal tran3 = new Withdrawal(2500,3456,600.35,5678,2,500);
	    System.out.println(tran3);
	    Withdrawal tran4 = new Withdrawal(2500,3456,tran3.getBalance(),5679,2,300);
	    System.out.println("(Account Id: " + tran4.getAccountId() + " TransNum: " + tran4.getTransNum() + " TransType: " +
	                       tran4.getTransType() + " ):(Withdrawal) Amount: " + tran4.getAmount() + " Fee: " + tran4.getFee() +
	                       " Balance: " + tran4.getBalance());

	    Deposit tran5 = new Deposit(2600,3456,1000,6783,3,1000);
	    Deposit tran6 = new Deposit(2700,3456,5000,6784,3,2000);
	    System.out.println(tran5.compareTo(tran6));
	    System.out.println(tran5);
	    System.out.println(tran6);

	  }

}
