import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program8 {
	public static void main(String[] args) {
		Dictionary dic;
		File file;
		
		if (args.length == 1) {
			dic = new Dictionary();
			file = new File(args[0]);
		} else if (args.length == 2) {
			dic = new Dictionary(Integer.parseInt(args[0]));
			file = new File(args[1]);
		} else {
			System.out.println("Usage: java Jumble [maxWordLength] filename");
			System.exit(1);
			return;
		}
		
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(1);
			return;
		}

		while (fileScanner.hasNext()) {
			dic.addEntry(fileScanner.next());
		}
		
		fileScanner.close();
		
		
		Scanner in = new Scanner(System.in);
		String word;
		
		System.out.print("Enter a scrambled word: ");
		
		while (!(word = in.nextLine()).isEmpty()) {
			
			String[] permutations = findPermutations(word);
			ArrayList<String> matches = new ArrayList<String>();
			for (int i = 0; i < permutations.length; i++) {
				if (dic.lookup(permutations[i])) {
					matches.add(permutations[i]);
				}
			}
			
			if (matches.size() > 0) {
				System.out.println("The words formed from '" + word + "' are:");
				for (int i=0; i < matches.size(); i++) {
					System.out.println(matches.get(i));
				}
			} else {
				System.out.println("No words are formed from '" + word + "'");
			}
			System.out.print("\nEnter a scrambled word: ");			
		}
		
		System.out.println("\n\nGoodbye");
		
		in.close();
	}
	public static String[] findPermutations(String s) {
		ArrayList<String> permutations = new ArrayList<String>();
		findPermutations(s, "", permutations);
		String[] retArray = permutations.toArray(new String[permutations.size()]);
		return retArray;
	}
	
	private static void findPermutations(String s1, String s2, ArrayList<String> permutations) {
		if (s1.length() <= 1) {
			String newString = s2 + s1;
			if (!permutations.contains(newString)) {
				permutations.add(newString);
			}
		} else {
			for (int i = 0; i < s1.length(); i++) {
				String newString = s1.substring(0, i) + s1.substring(i + 1);
				
				findPermutations(newString, s2 + s1.charAt(i), permutations);
			}
		}
	}
}
