
public abstract class Item {
	protected String name;
	protected int quantity;
	
	public Item(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuanitity() {
		return quantity;
	}
}
