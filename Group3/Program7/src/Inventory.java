import java.util.Date;
import java.util.ArrayList;

public class Inventory<T extends Item> {

	private ArrayList<T> items;
	
	public Inventory() {
		items = new ArrayList<T>();
	}

	public void addItem(T item) {
		items.add(item);
	}
	
	public T getItem(int index) {
		return items.get(index);
	}
	
	public int getQuantity(int index) {
		return items.get(index).getQuanitity();
	}
	
	public static <E extends Item> void printInventory(Inventory<E> inv) {
		for (int i = 0; i < inv.items.size(); i++) {
			System.out.println(inv.items.get(i).toString());
		}
	}
	
	public static <E extends DatedItem> E getOldestItemFromInventory(Inventory<E> inv) {
		
		if (inv.items.size() < 1) {
			return null;
		}
		
		E oldest = inv.items.get(0);
		
		for (int i = 1; i < inv.items.size(); i++) {
			if (oldest.compareTo(inv.items.get(i)) > 0) {
				oldest = inv.items.get(i);
			}
		}
		
		return oldest;
	}
	
	public static void addOrangesToInventory(Inventory<? super Orange> inv, String name, int quantity) {
		inv.addItem(new Orange(name, quantity, new Date()));
	}
	
}
