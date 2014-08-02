
public class HourlyEmployee extends Employee{
    private double wage;
    HourlyEmployee(String name, int hours, double wage){
        super(name,hours);
        this.hours = hours;
        this.wage = wage;
        this.hours = hours;     
    }
    @Override
    public String getType(){
        return "Hourly";
    }
    @Override
    public double totalPay(){
        return this.hours * this.wage;
    }
}
