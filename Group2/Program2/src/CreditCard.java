
public class CreditCard {
	private long number;
	private int month;
	private int year;
    private int cid;
    private String name;
    private String status;
    
    CreditCard(long newNumber, int newMonth, int newYear, int newCid, String newName){
        number = newNumber;
        month = newMonth;
        year = newYear;
        cid = newCid;
        name = newName;
        
        boolean numberStatus = isValid(number);
        
        if((numberStatus) && (cid >= 1000 && cid < 10000) 
        		&& (month > 0 && month < 13) && (year > 2011 && year < 2021)){
             status = "Valid Card";
        }
        else{
             if(!numberStatus){
            	 status = "Invalid Credit Card number";
             }      
             if((cid > 9999) || (cid < 0)){
                 status = "Invalid CID"; 
             }
             if((month > 12) || (month < 1)){
                 status = "Invalid Month";
             }
             if((year > 2020) || (year < 2012)){
                 status = "Invalid Year";
             }
        }
        
   }
   
   public long getCardNumber(){
        return number;
   }
   
   public int getMonth(){
        return month;
   }
   
   public int getYear(){
        return year;
   }
   
   public String getName(){
        return name;
   }
   
   public int getCID(){
        return cid;
   }
   
   long setCardNumber(long newNumber){
        number = newNumber;
        return number;
   }
   
   int setMonth(int newMonth){
        month = newMonth;
        return month;
   }
   
   int setYear(int newYear){
        year = newYear;
        return year;
   }
   
   String setName(String newName){
        name = newName;
        return name;
   }
   
   int setCID(int newCID){
        cid = newCID;
        return cid;
   }
   
   public String getStatus(){
        return status;
   }
   
   private boolean isValid(long number){
        int evenSum = sumOfEvenPlace(number);
        int oddSum = sumOfOddPlace(number);
        int sum = evenSum + oddSum;
        return sum % 10 == 0;
   }
   
   private int sumOfEvenPlace(long number){
        int sum = 0;
        
        for (int counter = 0, digit = 0; number > 0; counter++, number /= 10){
        	if(counter %  2 != 0){
                digit = getDigit(number);
                digit = 2 * digit;
                if(digit > 9)
                     digit = digit - 9;
                sum += digit;
           }
        }
        return sum;
   }
   
   /* return the number if it is a single digit, otherwise, return the sum of the two digits */
   private int getDigit(long number){
        return (int)(number % 10);
   }
   
   /*return sum of odd place digits in number*/
   private int sumOfOddPlace(long number){
        int sum = 0;
        
        for (int counter = 0; number > 0; counter++, number /= 10){
        	 if(counter % 2 == 0)
                 sum += getDigit(number);
        }

        return sum;
   }
   
   public String toString(){
        String type = typeOfCard();
        String cc = "Name: " + name + "\n Number: " + number + "\n Expiration Date: " + month + "/" + year + "\n CID: " + cid + "\n Type of Card: " + type + "\n Status: " + status;
        return cc;
   }
   
   //find type of card and return string
   public String typeOfCard(){
        long newNumber = number;
        int digit = 0;
        String type = "";
        while(newNumber > 0){
             digit = getDigit(newNumber);
             newNumber /= 10;
        }
        
        if (digit == 6){
            type = "Discover";
        }
        else if (digit == 3){ //this is acceptable
            type = "American Express";
        }
        else if (digit == 4){
            type = "Visa";
        }
        else if(digit == 5){
            type = "Mastercard";
        }
        return type;
   }

	
}
