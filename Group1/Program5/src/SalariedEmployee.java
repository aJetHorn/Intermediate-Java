
public class SalariedEmployee extends Employee{
	private double salary;
    public SalariedEmployee(String name, int hours, double salary){
        super(name, hours);
        this.salary = salary;
    }
    @Override
    public String getType(){
        return "Salaried";
    }
    @Override
    public double totalPay(){
        return salary / 52;
    }

}
