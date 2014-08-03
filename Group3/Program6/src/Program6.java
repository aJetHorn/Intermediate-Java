import java.util.Date;

public class Program6 {
	public static void main(String[] args) {
		AnimalHospital hospital = new AnimalHospital();
		hospital.readData("pets.data");
		hospital.printPetList();
		
		Dog updatedSpot = new Dog("Spot", "Dick", 0, new Date());
		int index = hospital.getPetIndex(updatedSpot);
		if (index >= 0) {
			System.out.println("\nVaccinating Dick's dog Spot... \n");
			((Dog) hospital.getPet(index)).setVaccineDate(updatedSpot.getVaccineDate());
			hospital.printPetList();
		}
	}
}
