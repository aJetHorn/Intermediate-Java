
public class Withdrawal extends Transaction{
	private double amount;
	private double fee;
	  
	  public Withdrawal(int acct, int p, double balance,int transNum, int transType, double amount){
	    super(acct,p,balance,transNum,transType);
	    this.amount = amount;
	    setFee();
	    setBalance(newBalance());
	  }

	  public double getAmount (){
	    return amount;
	  }

	  public double getFee(){
	    return fee;
	  }

	  public void setTransType(int transType){
	    if (transType == 2){
	      super.setTransType(transType);
	  }
	    else{
	      System.out.println("Wrong transType. TransType must be 2."); 
	    }
	  }
	  
	    private void setFee (){
	    if (amount >= 100)
	      fee = amount*.01;
	    else
	      fee = 1;
	  }
	    
	  public double newBalance (){
	    double balance = super.getBalance();
	   
	      balance = balance - amount - fee;
	      if(balance >= 0 ){
	      return balance;
	      }
	      
	    else{
	      System.out.println("Withdraw denied -- not enough balance");
	    }
	    return super.getBalance();
	  }
	    
	  public String toString (){
	    return super.toString() + "(Withdrawal) Amount: " +amount+ " Fee: "+fee+ " Balance: "+super.getBalance();
	  }

	  public boolean equals(Withdrawal object){
	      return super.equals(object) && amount == object.amount;
	  }

	  public int compareTo(Withdrawal object){
	    if(super.compareTo(object) != 0){
	      return (int)super.compareTo(object);
	    }
	    else{
		  return (int)(amount - object.amount);
	    }
	  }
}
