import java.util.Date;
public abstract class DatedItem extends Item implements Comparable<DatedItem> {
	protected Date packDate;

	public DatedItem(String name, int quantity, Date packDate) {
		super(name, quantity);
		this.packDate = packDate;
	}

	public Date getPackDate() {
		return packDate;
	}
	
	public int compareTo(DatedItem item) {
		return packDate.compareTo(item.packDate);
	}
}
