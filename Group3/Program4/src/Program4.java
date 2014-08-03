import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program4 {
	
	/*
	 * Opens a given file and loop through each line treating each
	 * line as a command to add or move a shape, clear the grid,
	 * or print the grid to the screen.
	 */
	public static void main(String[] args) {
		
		// Check to make sure that a filename is passed in
		if (args.length != 1) {
			System.out.println("Usage: java AsciiDisplay filename");
			System.exit(1);
			return;
		}
		
		// A scanner for the file
		Scanner file;
		
		// Try to create a new scanner for the inputed file
		try {
			file = new Scanner(new File(args[0]));
		} catch (FileNotFoundException e) {
			// Can't find the file; print an error and exit
			System.out.println("ERROR: Couldn't open file: " + args[0]);
			System.exit(1);
			return;
		}
		
		// Create an AsciiDisplay for the program
		AsciiDisplay dis = new AsciiDisplay();
		
		// Loop through the file line-by-line
		while (file.hasNextLine()) {
			
			// Break up the line into an array of command and fields
			String[] command = file.nextLine().split(" ");
			
			// Perform different behavior depending on command
			switch (command[0].toUpperCase()) {
			case "P": // P id x y
				// Create a new location for the point
				// and add it to display
				Coordinate pLoc = new Coordinate(
						Integer.parseInt(command[2]),
						Integer.parseInt(command[3])
						);
				dis.addShape(new Point(command[1], pLoc));
				break;
				
			case "R": // R id x y length height
				// Create a new location for the rectangle
				// and add it to display
				Coordinate rLoc = new Coordinate(
						Integer.parseInt(command[2]),
						Integer.parseInt(command[3])
						);
				int length = Integer.parseInt(command[4]);
				int height = Integer.parseInt(command[5]);
				dis.addShape(new Rectangle(command[1], rLoc, length, height));
				break;
				
			case "S": // S id x y size
				// Create a new location for the square
				// and add it to display
				Coordinate sLoc = new Coordinate(
						Integer.parseInt(command[2]),
						Integer.parseInt(command[3])
						);
				int size = Integer.parseInt(command[4]);
				dis.addShape(new Square(command[1], sLoc, size));
				break;
				
			case "M": // M id x y
				// Create a new location for the shapes and
				// call moveShape for the given id 
				Coordinate mLoc = new Coordinate(
						Integer.parseInt(command[2]),
						Integer.parseInt(command[3])
						);
				dis.moveShape(command[1], mLoc);
				break;
			case "E": // E
				// Erases all shapes by calling deleteAll()
				dis.deleteAll();
				break;
			case "D": // D
				// Draws the current set of shapes to the screen
				dis.printGrid();
				break;
			default:
				// Command not found so display and error message
				System.out.println("Invalid Command: " + command[0]);
			}
			
		}	
		file.close();
	}
}
