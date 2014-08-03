import java.util.Date;

public class Orange extends Fruit{
	public Orange(String name,int quantity, Date packDate) {
		super(name, quantity, packDate);
	}
	
	public String toString() {
		return name + " Orange, " + quantity + " fruits, Packaged: " + packDate;
	}
}
