import java.util.Date;

public abstract class Fruit extends DatedItem{
	public Fruit(String name, int quantity, Date packDate) {
		super(name, quantity, packDate);
	}
}
