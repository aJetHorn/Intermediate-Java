import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Program3 {
	public static void main(String[] args){
		if (args.length < 2){
			System.err.println("Must have at least two arguments");
		}
		String textFileName = args[0];
		String daleChallWordsFileName = args[1];
		StringBuilder builder = new StringBuilder();
		try{
			BufferedReader input = new BufferedReader(new FileReader(textFileName));
			String line;
			while ((line = input.readLine()) != null){
				builder.append(line);
				builder.append(" ");
			}
		}
		catch (IOException ex){
			System.out.println("Check input files - error in StringBuilder");
			System.exit(0);
		}
		String text = builder.toString();
		
		Text newText = new Text(text);
        DaleChall newDC = new DaleChall(newText, daleChallWordsFileName);
        newDC.printGradeLevel();
	}
}
