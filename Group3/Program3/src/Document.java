import java.io.File;
import java.util.Scanner;

public class Document {
private final static int MAX_WORDS = 100;
	
	private String[] terms;
	private int[] freqs;
	private double magnitude;
	
	public Document() {
		magnitude = 1;
	}

	public String[] getTerms() {
		return terms;
	}

	private static void sort(String[] list) {
		for (int i = 1; i < list.length; i++) {
			String currentElement = list[i];
			int k;
			// Move all elements greater than list[i] one position right
			for (k = i-1; k>=0 && list[k].compareTo(currentElement) > 0; k--) {
				list[k+1] = list[k];
			}
			list[k+1] = currentElement;
		}
	}
	
	private static int countDistinctStrings(String[] list) {
		int count = 0;

		if (list.length > 0) { 
			String lastElement = list[0];
			count = 1;

			for (int i=1; i < list.length; i++) {
				if (!list[i].equals(lastElement)) {
					count++;
					lastElement = list[i];
				}
			}
		}
		
		return count;
	}

	public void indexContent(String[] words) {
		Document.sort(words);
		int numDistinctStrings = Document.countDistinctStrings(words);
		
		terms = new String[numDistinctStrings];
		freqs = new int[numDistinctStrings];
		
		if (words.length > 0) { // Make sure we have items in the list
			String lastElement = words[0];
			int k = 0;
			
			// Start off with the first element
			terms[0] = words[0];
			freqs[0] = 1;

			for (int i=1; i < words.length; i++) {
				if (words[i].equals(lastElement)) {
					freqs[k]++;
				} else {
					k++;
					terms[k] = words[i];
					freqs[k] = 1;
					lastElement = words[i];
				}
			}
		}
		
		// Calculate the magnitude
		double sum = 0.0;
		for (int i = 0; i < terms.length; i++) {
			sum = sum + Math.pow(freqs[i], 2);
		}
		magnitude = Math.sqrt(sum);
	}
	
	public void printTermFreqs() {
		for (int i = 0; i < terms.length; i++) {
			System.out.printf("%-15s %-5d", terms[i], freqs[i]);
			
			// If we are on the last column, add a new line
			if (i % 4 == 3) {
				System.out.println();
			}
		}
	}
	
	private static int binarySearch(String[] list, String key) {
		int low = 0;
	    int high = list.length - 1;
	    
	    while (high >= low) {
	      int mid = (low + high) / 2;
	      if (key.compareTo(list[mid]) < 0) {
	        high = mid - 1;
	      } else if (key.equals(list[mid])) {
	        return mid;
	      } else {
	        low = mid + 1;
	      }
	    }
	    return -low - 1;
	}
	
	public int getFrequency(String term) {
		int loc = Document.binarySearch(terms, term);
		
		if (loc >= 0) {
			return freqs[loc];
		}
		
		return 0;
	}
	
	public double getSimilarity(String[] query) {
		int querySum = 0; // The sum of the frequencies is needed for the formula
		for (int i = 0; i < query.length; i++) {
			querySum = querySum + getFrequency(query[i]);
		}
		
		return querySum / (Math.sqrt(query.length) * magnitude);
	}
	
	public void indexFromFile(String fileName) throws Exception {
		Scanner file = new Scanner(new File(fileName));
		
		// Create an array with the maximum length
		String[] fileInput = new String[Document.MAX_WORDS]; 
		
		// Read the file while we haven't reached the end of the file
		// or exceed the size of our array
		int i = 0;
		while (file.hasNext() && i < fileInput.length) {
			fileInput[i] = file.next().toLowerCase();
			i++;
		}
		
		// Create a smaller array which has a length of the
		// number of words from the input.
		String[] words = new String[i];
		for (i = 0; i < words.length; i++) {
			words[i] = fileInput[i];
		}
		
		file.close();
		
		// Index the newly read words
		indexContent(words);
	}
}
