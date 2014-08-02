
public class Employee {
	protected String name;
    protected int hours;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    public String getType(){
        return null;
    }
    public Employee(String name, int hours){
        setName(name);
        setHours(hours);
    }
    public double totalPay(){
        return 0.0;
    }
    public static Employee factory(String name, String type, int hours, double wage, double salary){
        if (type.equalsIgnoreCase("hourly")){
            return new HourlyEmployee(name, hours, wage);
        }
        else{
            return new SalariedEmployee(name, hours, salary);
        }
    }

}
