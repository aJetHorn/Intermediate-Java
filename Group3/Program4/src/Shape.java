
public class Shape {

	protected String id;
	protected Coordinate location;
	
	public Shape(String id, Coordinate location) {
		this.id = id;
		this.location = location;
	}
	
	public void draw(AsciiDisplay dis) {
		dis.putCharAt(location.getX(), location.getY(), '?');
	}
	
	public void move(Coordinate newLoc) {
		location = newLoc;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Shape) {
			return ((Shape) obj).id == id;
		}
		return false;
	}
}
