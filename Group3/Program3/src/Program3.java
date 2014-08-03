import java.util.Scanner;

public class Program3 {
	public static void main(String[] args) throws Exception {
		
		if (args.length != 1) {
			System.out.println("Usage: java Document filename");
			System.exit(1);
		}
		
		// Create a new Document object and load the file into it
		Document doc = new Document();
		doc.indexFromFile(args[0]);
		
		System.out.println("Tem frequency list for " + args[0]);
		doc.printTermFreqs();
		
		boolean anotherQuery = true;
		Scanner in = new Scanner(System.in);
		
		System.out.println();
		
		// Continually prompt the user for query terms to check against the document
		while (anotherQuery) {
			System.out.println();
			System.out.println("Enter a query:");
			String[] query = in.nextLine().toLowerCase().split(" "); // Will only check on spaces
			System.out.printf("Similarity = %.3f\n", doc.getSimilarity(query));
			
			System.out.println();
			System.out.println("Compare another query? (Y/N)");
			anotherQuery = in.nextLine().equalsIgnoreCase("Y");
		}
		
		in.close();
	}
}
