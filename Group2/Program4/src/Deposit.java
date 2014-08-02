
public class Deposit extends Transaction{
	private double amount;
	 /*Description: construct an object of Deposit type */
	    public Deposit(int acct, int p, double balance,int transNum, int transType, double amount){
	    super(acct,p,balance,transNum,transType);
	    this.amount = amount;
	    newBalance();
	  }
	     /*Description: the purpose of this method is to get amount
	   * PreCondition: this method is called
	   * PostCondition: this method will return the amount*/
	  public double getAmount (){
	    return amount;
	  }
	    /*Description: the purpose of this method is to change the TransType
	   * PreCondition: the transType number will be checked for validity
	   * PostCondition: the transType will be set to a new one if it equals to 3 */  
	  public void setTransType(int transType){
	    if (transType == 3){
	    super.setTransType(transType);
	  }
	    else{
	      System.out.println("Wrong transType. TransType must be 3"); 
	      System.exit(0);
	    }
	  }
	   /*Description:the method set a new balance 
	  * PreCondition:grabs balance and amount
	  Post Condition:set balance to a new one by adding balance to amount*/
	  public void newBalance(){
	    double balance = getBalance();
	    balance = balance + amount;
	    super.setBalance(balance);
	     
	  }
	  /*Description: this method is to print out the credit card's information
	   * PreCondition: this method grabs the amount, and balancel, accountid, p, ect from those global variables
	   * PostCondition: this method prints out the credit card's information*/
	    public String toString (){
	    return super.toString() + "(Deposit) Amount: " +amount+ "Balance: " + super.getBalance();
	  }
	     /*Description:the method checks if two deposit objects are equal
	  * PreCondition:grabs accountId,p,balance, amount and getBlalance
	  Post Condition:compare if the two deposit are equal to each other*/
	    public boolean equals(Deposit object){
	      return super.equals(object) && amount == object.amount;
	  }
	     /*Description:the method get the difference of two deposit objects if they are not the same
	  * PreCondition:grabs accountId,p,balance, amount and getBlalance
	  Post Condition:compare and get difference if the two deposit are not equal to each other*/
	  public double compareTo(Deposit object){
	    if(super.compareTo(object)!= 0)
	      return (int)super.compareTo(object);
	    else
	      return this.amount - object.amount;
	  }

}
