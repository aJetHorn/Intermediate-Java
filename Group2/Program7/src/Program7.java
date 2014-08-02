
public class Program7 {
	  public static void main(String [] args) { 
		    DoubleOrderedList list = new DoubleOrderedList();   
		    list.add("Snake",30);    
		    list.add("Zebra",10);   
		    list.add("Cat",40);   
		    list.add("Dog",25);   
		    System.out.println(list);   
		    System.out.println(list.printAmount());  
		    list.delete("Dog");     
		    System.out.println(list);  
		    System.out.println(list.printAmount());  
		  } 
}
