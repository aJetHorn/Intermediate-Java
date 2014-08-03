import java.util.Scanner;

public class Program2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numOfStudents;
		int[] scores;
		float average;
		
		System.out.print("Enter the number of students: ");
		numOfStudents = scanner.nextInt();
		
		System.out.printf("Enter %d scores: ", numOfStudents);
		scores = new int[numOfStudents];
		
		for (int i = 0; i < numOfStudents; i++) {
			scores[i] = scanner.nextInt();
		}
		
		average = calcAverage(scores);
		System.out.printf("The class average is: %.1f\n", average);
		
		for (int i = 0; i < numOfStudents; i++) {
			System.out.printf("Student %d score is %d and grade is %s\n",
					i, scores[i], calcGrade(scores[i], average));
		}
		scanner.close();
	}
	
	public static float calcAverage(int[] nums) {
		float sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum / nums.length;
	}
	
	public static String calcGrade(int score, float average) {
		
		if (score >= average * 1.2) {
			return "A";
		} 
		else if (score >= average * 1.1) {
			return "B";
		} 
		else if (score >= average * 0.9) {
			return "C";
		} 
		else if (score >= average * 0.8) {
			return "D";
		}
		//else can be omitted
		return "F";		
	}
}
