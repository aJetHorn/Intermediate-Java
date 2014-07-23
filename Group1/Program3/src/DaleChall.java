import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DaleChall {
	private Text text;
	private String words[];
	
	public DaleChall(Text text, String filename){
		words = new String[3000];
		readList(filename);
		this.text = text;
	}
	
	private void readList(String filename){
		int numWords = 0;
		try{
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = in.readLine()) != null){
				numWords++;
				words[numWords - 1] = line.trim();
			}
		}
		catch (IOException ex){
			System.out.println("There was an error in StringBuilder, check input file(s)");
			System.exit(0);
		}
	}
	
	private boolean isWordOnList(String word){
		for (int i = 0; i < words.length; i++){
			if (word.equalsIgnoreCase(words[i])){
				return true;
			}
		}
		return false;
	}
	
	public double calcReadingEase(){
		double PDW;
		double ASL = (double)text.getWordCount() / text.getSentenceCount();
		double matches = 0;
		String[] textArray = text.getWords();
		for (int i = 0; i < textArray.length; i++){
			if (isWordOnList(textArray[i])){
				matches++;
			}
		}
		
		PDW = ((text.getWordCount() - matches) / text.getWordCount()) * 100;
		double rawScore = (.1579 * PDW + .0496 * ASL + 3.6365);
		System.out.println("Raw score: " + rawScore);
		return rawScore;
	}
	
    public void printGradeLevel()
    {
        double readingEase = calcReadingEase();
        if (readingEase >= 10)
        {
            System.out.println("Grades 16 and above");
        }
        else if (readingEase >= 9)
        {
            System.out.println("Grades 13-15 (college)");
        }
        else if (readingEase >= 8)
        {
            System.out.println("Grades 11-12");
        }
        else if (readingEase >= 7)
        {
            System.out.println("Grades 9-10");
        }
        else if (readingEase >= 6)
        {
            System.out.println("Grades 7-8");
        }
        else if (readingEase >= 5)
        {
            System.out.println("Grades 5-6");
        }
        else
        {
            System.out.println("Grade 4 and below");
        }
    }
}
