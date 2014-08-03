
public abstract class Pet {
	protected String name;
	protected String owner;
	protected double weight;
	
	public Pet(String name, String owner, double weight) {
		this.name = name;
		this.owner = owner;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}
	
	public String getOwner() {
		return owner;
	}

	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public abstract String getSize();
	
	public String toString() {
		return name + " owned by " + owner + ": " + getSize() + " Pet, " + weight + " lbs";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Pet) {
			return ((Pet)o).name.equals(name) && ((Pet)o).owner.equals(owner);
		}
		return false;
	}
}
