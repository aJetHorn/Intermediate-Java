
public class Transaction extends Account{
	 
	  private int transNum;
	  private int transType;
	   /*Description: construct an object of Transaction type */
	  public Transaction(int acct, int p, double balance,int transNum, int transType){
	    super(acct,p,balance);
	    setTransNum(transNum);
	    setTransType(transType);
	  }
	   /*Description: the purpose of this method is to get TransNum
	   * PreCondition: this method is called
	   * PostCondition: this method will return the transNum*/
	  public int getTransNum(){
	    return transNum;
	  }

	   /*Description: the purpose of this method is to get TransType
	   * PreCondition: this method is called
	   * PostCondition: this method will return the TransType*/
	  public int getTransType(){
	    return transType;
	  }
	   /*Description: the purpose of this method is to change the TransNum
	   * PreCondition: the transType number will be checked for validity
	   * PostCondition: the transType will be set to a new one if it is a 4-digit number */ 
	  public void setTransNum(int transNum){
	    if (transNum >= 1000 && transNum <= 9999){ 
	    this.transNum = transNum;
	    }
	  }
	     /*Description: the purpose of this method is to set TransType
	   * PreCondition: this method is called
	   * PostCondition: this method will return the TransType if it equals to 1 or 2 or 3 or 4, otherwise it will kick the user out of the program*/
	  public void setTransType(int transType){
	    if (transType == 1 || transType == 2|| transType==3 || transType == 4){
	    this.transType = transType;
	  }
	    else
	      System.exit(0);
	  }
	    /*Description: this method is to print out the credit card's information
	   * PreCondition: this method grabs the amount, and balancel, accountid, p, ect from those global variables
	   * PostCondition: this method prints out the credit card's information*/
	  public String toString(){
	    return "(Account Id: " +super.getAccountId()+" TransNum: "+ transNum+ " TransType: "+transType+" )";
	  }
	      /*Description:the method checks if two deposit objects are equal
	  * PreCondition:grabs accountId,p,balance, amount and getBlalance
	  Post Condition:compare if the two deposit are equal to each other*/ 
	  public boolean equals(Transaction object){
	    return (((Integer)this.transNum).equals(((Integer)object.transNum)) && ((Integer)this.transType).equals((Integer)object.transType) && ((Integer)getAccountId()).equals((Integer)object.getAccountId()));
	  }
	       /*Description:the method get the difference of two deposit objects if they are not the same
	  * PreCondition:grabs accountId,p,balance, amount and getBlalance
	  Post Condition:compare and get difference if the two deposit are not equal to each other*/
	  public int compareTo(Transaction object){
	    if(this.getAccountId() - object.getAccountId() != 0)
	      return (this.getAccountId() -  object.getAccountId());
	    else 
	      return (this.transNum - object.transNum);
	  }

}
