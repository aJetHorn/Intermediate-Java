
public class Bird extends Pet {
	private boolean clipped;

	public Bird(String name, String owner, double weight, boolean clipped) {
		super(name, owner, weight);
		this.clipped = clipped;
	}
	
	public boolean isClipped() {
		return clipped;
	}
	
	public void setClipped(boolean clipped) {
		this.clipped = clipped;
	}
	
	public String getSize() {
		if (weight > 2) {
			return "Large";
		} 
		else if (weight < 0.1) {
			return "Small";
		} 
		else {
			return "Medium";
		}
	}
	
	public String toString() {
		if (!clipped) {
			return name + " owned by " + owner + ": " + getSize() + " Bird, " + weight + " lbs, not clipped";	
		} 
		else{
			return name + " owned by " + owner + ": " + getSize() + " Bird, " + weight + " lbs";	
		}
	}
}
