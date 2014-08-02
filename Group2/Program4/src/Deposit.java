
public class Deposit extends Transaction{
	private double amount;
	    public Deposit(int acct, int p, double balance,int transNum, int transType, double amount){
	    super(acct,p,balance,transNum,transType);
	    this.amount = amount;
	    newBalance();
	  }

	  public double getAmount (){
	    return amount;
	  }
	  
	  public void setTransType(int transType){
	    if (transType == 3){
	    super.setTransType(transType);
	  }
	    else{
	      System.out.println("Wrong transType. TransType must be 3"); 
	      System.exit(0);
	    }
	  }

	  public void newBalance(){
	    double balance = getBalance();
	    balance = balance + amount;
	    super.setBalance(balance);
	     
	  }
	  
	    public String toString (){
	    return super.toString() + "(Deposit) Amount: " +amount+ "Balance: " + super.getBalance();
	  }
	 
	    public boolean equals(Deposit object){
	      return super.equals(object) && amount == object.amount;
	  }
	
	  public double compareTo(Deposit object){
	    if (super.compareTo(object)!= 0){
	    	return (int)super.compareTo(object);
	    }  
	    else{
	    	return this.amount - object.amount;
	    }   
	  }

}
