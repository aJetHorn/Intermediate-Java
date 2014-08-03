import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AnimalHospital {
	private ArrayList<Pet> pets;

	public AnimalHospital() {
		pets = new ArrayList<Pet>();
	}
	
	public void addPet(Pet pet) {
		pets.add(pet);
	}
	
	public void readData(String filename) {
		Scanner in;
		try {
			in = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			// Can't find the file; print out an error and exit
			System.out.println("ERROR - Could not open file " + filename + ".");
			System.exit(1);
			return;
		}
		
		int lineNum = 0;
		
		while (in.hasNextLine()) {			
			lineNum++;
			String[] pet = in.nextLine().split("\\s+");
			
			SimpleDateFormat stdDate = new SimpleDateFormat("MM/dd/yy");
			
			switch (pet[0].toUpperCase()) {
			case "DOG":
				Date vaccineDate;
				try {
					vaccineDate = stdDate.parse(pet[4]);
					Dog dog = new Dog(pet[1], pet[2], Double.parseDouble(pet[3]), vaccineDate, Boolean.parseBoolean(pet[5]));
					pets.add(dog);
				} catch (ParseException e) {
					System.out.println("ERROR - Vaccine date date-string is not in mm/dd/yy format! Skipping line " + lineNum + "...");
					break;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("ERROR - Missing fields. Skipping line " + lineNum + "...");
					break;
				}
				break;
			case "BIRD":
				try {
					Bird bird = new Bird(pet[1], pet[2], Double.parseDouble(pet[3]), Boolean.parseBoolean(pet[4]));
					pets.add(bird);
				} catch (IndexOutOfBoundsException e) {
					// If it's missing a field then it is the incorrect format
					System.out.println("ERROR - Missing fields. Skipping line " + lineNum + "...");
					break;
				}
				break;
			default:
				System.out.println("ERROR - " + pet[0] + " is not a valid animal! Skipping line " + lineNum + "..");
			}
		}
		in.close();
	}
	
	public void printPetList() {
		for (int i = 0; i < pets.size(); i++) {
			System.out.println(pets.get(i).toString());
		}
	}
	
	public int getPetIndex(Pet pet) {
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).equals(pet)) {
				return i;
			}
		}		
		return -1;
	}
	
	public Pet getPet(int index) throws IndexOutOfBoundsException {
		return pets.get(index);
	}
}
