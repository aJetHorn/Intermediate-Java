
public class Transaction extends Account{
	  private int transNum;
	  private int transType;

	  public Transaction(int acct, int p, double balance,int transNum, int transType){
	    super(acct,p,balance);
	    setTransNum(transNum);
	    try{
	      setTransType(transType);
	    } catch(InvalidTransTypeException e){
	      System.out.println(e.getMessage());
	      System.exit(0);
	    }
	  }

	  public int getTransNum(){
	    return transNum;
	  }

	  public int getTransType(){
	    return transType;
	  }

	  public void setTransNum(int transNum){
	    if (transNum >= 1000 && transNum <= 9999){ 
	    	this.transNum = transNum;
	    }
	  }

	  public void setTransType(int transType) throws InvalidTransTypeException{
	    if (transType == 1 || transType == 2|| transType==3 || transType == 4){
	    this.transType = transType;
	  }
	    else
	      throw new InvalidTransTypeException ("Invalid type, must be 1 2 3 4. ");
	  }

	  public String toString(){
	    return "(Account Id: " + super.getAccountId() + " TransNum: " +
	  transNum + " TransType: " + transType  +" )";
	  }

	  public boolean equals(Transaction object){
	    return (((Integer)this.transNum).equals(((Integer)object.transNum)) && ((Integer)this.transType).equals((Integer)object.transType) && ((Integer)getAccountId()).equals((Integer)object.getAccountId()));
	  }
	  
	  public int compareTo(Transaction object){
	    if(this.getAccountId() - object.getAccountId() != 0)
	      return (this.getAccountId() -  object.getAccountId());
	    else 
	      return (this.transNum - object.transNum);
	  }

}
