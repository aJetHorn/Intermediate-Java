import java.util.ArrayList;

public class AsciiDisplay {
	private char[][] grid;
	private ArrayList<Shape> shapes;

	public AsciiDisplay() {
		grid = new char[30][15];
		shapes = new ArrayList<Shape>();
	}
	
	public void addShape(Shape s) {
		shapes.add(s);
	}
	
	public int moveShape(String id, Coordinate newLoc) {
		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i).id.equals(id)) {
				shapes.get(i).move(newLoc);
				return 0;
			}
		}	
		return -1;
	}

	public void printGrid() {
		
		// Make sure the grid is up to date
		updateGrid();
		
		System.out.println("+------------------------------+");
		
		// Loop through the rows of the grid
		for (int y = 0; y < 15; y++) {
			System.out.print("|");
			
			for (int x = 0; x < 30; x++) {
				System.out.print(grid[x][y]);
			}
			
			System.out.print("|\n");
		}
		
		System.out.println("+------------------------------+");
	}
	
	public void deleteAll() {
		shapes.clear();
	}
	
	void putCharAt(int x, int y, char c) {
		grid[x][y] = c;
	}

	private void updateGrid() {

		// Clear the current grid
		grid = new char[30][15];
		
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).draw(this);
		}
	}
}
