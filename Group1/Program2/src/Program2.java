import java.util.Scanner;
public class Program2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of tenants: ");
        int arraySize = input.nextInt();
        Tenant[] tenantArray = new Tenant[arraySize];
        populateTenantArray(tenantArray);
        printTenants(tenantArray);
	}
	public static void populateTenantArray(Tenant[] tenantArray){
		if (tenantArray.length == 0){
			System.out.println("No tenants");
		}
		else{
			Scanner input = new Scanner(System.in);
			for (int x = 0; x < tenantArray.length; x++){
				System.out.print("\nEnter tenant's first name: ");
				String firstName = input.next();
				System.out.print("Enter tenant's last name: ");
				String lastName = input.next();
        		System.out.print("Enter tenant's Apt Number: ");
        		String aptNumber = input.next();
        		System.out.print("Enter tenant's Yearly Rent: ");
        		int yearlyRent = input.nextInt();
        		tenantArray[x] = new Tenant(firstName, lastName, aptNumber, yearlyRent);
			}
		}
		
	}
	public static void printTenants(Tenant[] tenantArray){
        for (int x = 0; x < tenantArray.length; x++){
            System.out.println("Tenant's full name is " + tenantArray[x].fullName());
            System.out.println("Tenant's Apartment Number is " + tenantArray[x].getAptNumber());
            System.out.println("Tenant's first payment is " + tenantArray[x].firstPayment());
            System.out.println("Tenant's monthly payment for next 11 months is: " + tenantArray[x].monthlyPayment());
            System.out.println();
        }
	}
}
