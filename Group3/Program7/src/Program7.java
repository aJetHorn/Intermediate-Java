import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class Program7 {
	public static void main(String[] args) {
	    SimpleDateFormat basicDates = new SimpleDateFormat("MM/dd/yy");
	    Inventory<Milk> stockMilk = new Inventory<Milk>();
	    try {
	      stockMilk.addItem(new Milk("2%", 10, basicDates.parse("11/15/12")));
	      stockMilk.addItem(new Milk("Whole", 5, basicDates.parse("10/12/12")));
	      stockMilk.addItem(new Milk("No Fat", 12, basicDates.parse("11/13/12")));
	    } catch (ParseException ex) {
	      System.out.println(ex.getMessage());
	      System.exit(1);
	    }
	    System.out.println("Milk Inventory:");
	    System.out.println("---------------------------");
	    Inventory.printInventory(stockMilk);
	    System.out.println();
	    System.out.println("Quantity of Item #2: " + stockMilk.getQuantity(2));
	    
	    Milk oldMilk = Inventory.<Milk>getOldestItemFromInventory(stockMilk);
	    System.out.println();
	    System.out.println("Oldest Item: " + oldMilk.toString());
	    Inventory<Fruit> stockFruit = new Inventory<Fruit>();
	    Inventory.addOrangesToInventory(stockFruit, "Clementine", 20);
	    System.out.println();
	    System.out.println("Fruit Inventory:");
	    System.out.println("---------------------------");
	    Inventory.printInventory(stockFruit);
	  }
	
	class Milk extends DatedItem {
		  public Milk(String name, int quantity, Date packDate) {
		    super(name, quantity, packDate);
		  }
		  
		  public String toString() {
		    return name + " Milk, " + quantity + " units, Packaged: " + packDate;
		  }
	}
}
