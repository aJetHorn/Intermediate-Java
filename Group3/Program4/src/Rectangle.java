
public class Rectangle extends Shape{
	private int length;
	private int height;
	
	public Rectangle(String id, Coordinate loc, int length, int height) {
		super(id, loc);
		this.length = length;
		this.height = height;
	}
	
	public void draw(AsciiDisplay dis) {
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < height; y++) {
				dis.putCharAt(location.getX() + x, location.getY() + y, '#');
			}
		}
	}
}
