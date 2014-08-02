
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Program5 {
	public static void main(String[] args) {
	       if (args.length < 1){
	           System.out.println("Prog5 Usage: <textFileName>");
	       }
	       else{
	           List<Employee> employees = new ArrayList<>();
	           String fileName = args[0];
	           try{
	               BufferedReader in = new BufferedReader(new FileReader(fileName));
	               String line;
	               while ((line = in.readLine()) != null ){
	                  String[] lineFields = line.trim().split("\\s+");
	                   //<name><type><hours><wage><salary>
	                   employees.add(Employee.factory(lineFields[0],lineFields[1],
	                           Integer.parseInt(lineFields[2]),Double.parseDouble(lineFields[3]), 
	                           Double.parseDouble(lineFields[4])));
	                }
	               
	           }
	            catch (IOException ex){
	            System.out.println("There was an error, check input file(s)");
	            System.exit(0);
	        }//10 char two blanks
	           System.out.printf("%-12s%-12s%12s%12s%n","Name","Type","Hours","Total Pay");
	           double totalPayOfAll = 0;
	           for (int i = 0; i < employees.size(); i++){
	               Employee temp = employees.get(i); //creates temporary employee
	               System.out.printf("%-12.10s%-12.10s  %10d  %10.2f%n", temp.getName(), temp.getType(), temp.getHours(), temp.totalPay());
	               totalPayOfAll += temp.totalPay();
	           }
	           System.out.printf("%48.2f", totalPayOfAll);
	       }
	    }

}
