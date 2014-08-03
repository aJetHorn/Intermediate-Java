
public class Point extends Shape{

	public Point(String id, Coordinate loc) {
		super(id, loc);
	}

	public void draw(AsciiDisplay dis) {
		dis.putCharAt(location.getX(), location.getY(), '*');
	}
}
