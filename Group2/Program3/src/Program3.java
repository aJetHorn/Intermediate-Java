
public class Program3 {
	public static void main(String [] args){
		Account customer1 = new Account(956,888,-5);
		Account customer2 = new Account(1234,4321,1200.50);
		Account customer3 = new Account(2345,3456,200);
		System.out.println("Customer 1: " + customer1); 
		System.out.println("Customer 2: " + customer2); 
		System.out.println("Customer 3: " + customer3); 
		System.out.println(customer1.equals(customer3));
	}
}
