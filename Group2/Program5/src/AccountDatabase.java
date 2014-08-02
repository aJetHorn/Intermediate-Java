import java.util.*;
import java.io.*;

public class AccountDatabase {
	Transaction [] data;
	  int numAccts;
	  Scanner inputStream;
	  java.io.PrintWriter outputStream;
	    
	  public AccountDatabase(){  
	    setInputStream(null);
	    setOutputStream(null);
	    setDataArray(100);
	    setNumAccts(0);
	  }

	  public void setInputStream(Scanner inputStream){
	    this.inputStream = inputStream;
	  }

	  public void setOutputStream(PrintWriter outputStream){
	    this.outputStream = outputStream;
	  }

	  public void setDataArray(int length){
	    data = new Transaction [length];
	  }

	  public void setNumAccts(int numAccts){
	    this.numAccts = numAccts;
	  }

	  public void readTransaction (String field) {

	    File file = new File(field);
	    try{
	    inputStream = new Scanner(file);
	    
	    while (inputStream.hasNext()){
	      String type = inputStream.next();
	            
	      Transaction myTrans = null;
	      
	      if(type.equals("D")) {
	        try{
	      int accountId = inputStream.nextInt();
	      int pin = inputStream.nextInt();
	      double balance = inputStream.nextDouble();
	      int transNum = inputStream.nextInt();
	      int transType = inputStream.nextInt();
	      double amount = inputStream.nextDouble();
	      
	      myTrans = new Deposit(accountId,pin,balance,transNum,transType,amount); 
	      
	            data[numAccts] = myTrans;
	            numAccts ++;
	        }catch (InputMismatchException ex){
	          System.out.println("Incorrect input type.");
	          System.exit(0);
	        }
	      }else if (type.equals("T")) {
	        try{
	      int accountId = inputStream.nextInt();
	      int pin = inputStream.nextInt();
	      double balance = inputStream.nextDouble();
	      int transNum = inputStream.nextInt();
	      int transType = inputStream.nextInt();
	      
	      myTrans  = new Transaction (accountId, pin, balance,transNum,transType); 
	      
	            data[numAccts] = myTrans;
	            numAccts ++;  
	        
	        }catch(InputMismatchException ex){
	         System.out.println("Incorrect input type.");
	         System.exit(0);
	      }
	      }else if (type.equals("W")) {
	        
	        try{
	      int accountId = inputStream.nextInt();
	      int pin = inputStream.nextInt();
	      double balance = inputStream.nextDouble();
	      int transNum = inputStream.nextInt();
	      int transType = inputStream.nextInt();
	      double amount = inputStream.nextDouble();
	      
	      myTrans = new Withdrawal (accountId,pin,balance,transNum,transType,amount);
	        data[numAccts] = myTrans;
	            numAccts ++; 
	        }catch(InputMismatchException ex){
	          System.out.println("Incorrect input type.");
	          System.exit(0);
	        }
	      }
	        else {
	        System.out.println("Invalid transcation type");
	        System.exit(0);
	      }
	    }
	    
	inputStream.close();     
	    }catch (FileNotFoundException e){
	      System.out.println("File does not exist.");
	      System.exit(0);
	    }
	sortArray();
	  }
	  
	  public void printTransactions( ){
	    for(int i = 0; i < numAccts; i++){
	      if(data[i] != null){
	    System.out.println(data[i]+" ");
	      }
	    }
	  }
	  
	  private void sortArray(){
	    
	    for (int i = 0; i<data.length-1;i++){
	      if(data[i] != null){
	      int currentMin = data[i].getTransNum();
	      int currentMinIndex = i;
	      for (int j = i+1; j<numAccts;j++){
	        if (currentMin > data[j].getTransNum()){
	          currentMin = data[j].getTransNum();
	          currentMinIndex = j;
	        }
	      }
	      
	      if (currentMinIndex != i){
	        Transaction temp=data[currentMinIndex];
	        data[currentMinIndex]=data[i];
	        data[i]=temp;
	      }
	      }
	    }
	    }

	  public Transaction findTrans(int key){
	    int low = 0;
	    int high = numAccts;
	    
	    while (high >= low){
	      int mid = (low+high)/2;
	      if(key < data[mid].getTransNum())
	        high = mid-1;
	      
	      else if (key == data[mid].getTransNum())
	        return data[mid];
	      else{
	        low = mid+1;}}
	    System.out.println("Transaction not found.");
	    return null;
	  }
	  
	public void backUpDatabase(String printFile){
	File outfile=new File(printFile);
	try{
	outputStream=new PrintWriter(outfile);
	for (int i=0;i<numAccts;i++){

	if(data[i] instanceof Deposit){
		outputStream.print("D ");
		outputStream.print(data[i].getAccountId() + " ");
		outputStream.print(data[i].getPin() + " ");
		outputStream.print(data[i].getBalance() - ((Deposit)data[i]).getAmount() + " ");
		outputStream.print(data[i].getTransNum() + " ");
		outputStream.print(data[i].getTransType() + " ");
		outputStream.print(((Deposit)data[i]).getAmount() + " ");
		outputStream.println();
	}
	else if(data[i] instanceof Withdrawal){
		outputStream.print("W ");
		outputStream.print(data[i].getAccountId() + " ");
		outputStream.print(data[i].getPin() + " ");
		outputStream.print(data[i].getBalance() + ((Withdrawal)data[i]).getAmount()+ ((Withdrawal)data[i]).getFee() + " ");
		outputStream.print(data[i].getTransNum() + " ");
		outputStream.print(data[i].getTransType() + " ");
		outputStream.print(((Withdrawal)data[i]).getAmount()+ " ");
		outputStream.println();
	}
	else if(data[i] instanceof Transaction){
		outputStream.print("T ");
		outputStream.print(data[i].getAccountId() + " ");
		outputStream.print(data[i].getPin() + " ");
		outputStream.print(data[i].getBalance() + " ");
		outputStream.print(data[i].getTransNum() + " ");
		outputStream.print(data[i].getTransType() + " ");
		outputStream.println();
		}
	}
		outputStream.close();
	}
	catch(FileNotFoundException e){
	System.out.println("File does not exist");
	}
	}

	public void recoverBackUp (String file){
	    data = new Transaction[100];
	    readTransaction(file);
	  }

}
