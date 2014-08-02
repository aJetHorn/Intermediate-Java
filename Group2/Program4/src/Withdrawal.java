
public class Withdrawal extends Transaction{
	private double amount;
	  private double fee;
	  
	     /*Description: construct an object of Deposit type */
	  public Withdrawal(int acct, int p, double balance,int transNum, int transType, double amount){
	    super(acct,p,balance,transNum,transType);
	    this.amount = amount;
	    setFee();
	    setBalance(newBalance());
	  }
	     /*Description: the purpose of this method is to get amount
	   * PreCondition: this method is called
	   * PostCondition: this method will return the amount*/
	  public double getAmount (){
	    return amount;
	  }
	     /*Description: the purpose of this method is to get fee
	   * PreCondition: this method is called
	   * PostCondition: this method will return the fee*/
	  public double getFee(){
	    return fee;
	  }
	      /*Description: the purpose of this method is to change the TransType
	   * PreCondition: the transType number will be checked for validity
	   * PostCondition: the transType will be set to a new one if it equals to 2 */  
	  public void setTransType(int transType){
	    if (transType == 2){
	      super.setTransType(transType);
	  }
	    else{
	      System.out.println("Wrong transType. TransType must be 2."); 
	    }
	  }
	    /*Description: the purpose of this method is to change the fee
	   * PreCondition: the fee number will be checked for validity
	   * PostCondition: if amount is bigger than 100, the fee will be 1% of the amount, otherwise fee is 1 */   
	    private void setFee (){
	    if (amount >= 100)
	      fee = amount*.01;
	    else
	      fee = 1;
	  }
	    
	   /*Description:the method set a new balance 
	  * PreCondition:grabs balance and amount
	  Post Condition:set balance to a new one by subtracting amount from balance if the balance is larger than 0, else will return a message saying not enough balance*/
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
	    
	    /*Description: this method is to print out the credit card's information
	   * PreCondition: this method grabs the amount, and balancel, accountid, p, ect from those global variables
	   * PostCondition: this method prints out the credit card's information*/ 
	  public String toString (){
	    return super.toString() + "(Withdrawal) Amount: " +amount+ " Fee: "+fee+ " Balance: "+super.getBalance();
	  }
	       /*Description:the method checks if two deposit objects are equal
	  * PreCondition:grabs accountId,p,balance, amount and getBlalance
	  Post Condition:compare if the two deposit are equal to each other*/
	  public boolean equals(Withdrawal object){
	      return super.equals(object) && amount == object.amount;
	  }
	       /*Description:the method get the difference of two deposit objects if they are not the same
	  * PreCondition:grabs accountId,p,balance, amount and getBlalance
	  Post Condition:compare and get difference if the two deposit are not equal to each other*/
	  public int compareTo(Withdrawal object){
	    if(super.compareTo(object) != 0){
	      return (int)super.compareTo(object);
	    }
	    else
	      return (int)(amount - object.amount);
	  }

}
