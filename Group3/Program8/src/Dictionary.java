import java.util.ArrayList;

public class Dictionary {
	private ArrayList<ArrayList<String>> words;
	private int maxWordLength;	

	public Dictionary(int maxWordLength) {

		this.maxWordLength = maxWordLength;
		words = new ArrayList<ArrayList<String>>(maxWordLength);
		
		for (int i = 0; i < maxWordLength; i++) {
			words.add(new ArrayList<String>());
		}
	}

	public Dictionary() {
		this(10);
	}

	public void addEntry(String word) {

		if (word.length() < maxWordLength) {
			ArrayList<String> list = words.get(word.length() - 1);
			list.add(word);
		}
	}

	public boolean lookup(String s) {
		ArrayList<String> list = words.get(s.length() - 1);
		return Dictionary.search(list, s, 0, list.size() - 1) > 0;
	}

	private static int search(ArrayList<String> list, String key, int low,
			int high) {
		if (low > high) {
			return -low - 1;
		}

		int mid = (low + high) / 2;
		if (key.compareTo(list.get(mid)) < 0) {
												
			return search(list, key, low, mid - 1);
		} else if (key.equals(list.get(mid))) { 
			return mid;
		} else {
			return search(list, key, mid + 1, high);
		}
	}
}
