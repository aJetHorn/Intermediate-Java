/*
 * The program prompts the user
 * for a root word, a rhyme word, and a degree. The program then creates a list
 * of all synonyms of the rootword and calculates which (if any) synonyms rhyme
 * with the rootword and how many degrees (basically syllables) rhyme. It figures
 * out what rhymes by breaking apart each word into pronounciations. The program
 * then produces and prints a list of all these rhyming words.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program7 {
    public static void main(String[] args) {
        
        PronouncingDictionary proDict = new PronouncingDictionary("cmudictEDIT.0.7a.txt","cmudict.0.7a.phones.txt");
        Scanner input = new Scanner(System.in);
        
        while (true){
            System.out.println("Enter a root word. . .");
            String rootWord = input.next();
            if (rootWord.equals("") || rootWord.length() == 0){
                System.out.println("Improper input");
                System.exit(0);
            }
            System.out.println("Enter a rhyme word. . .");
            String rhymeWord = input.next();
            if (rhymeWord.equals("") || rhymeWord.length() == 0){
                System.out.println("Improper input");
                System.exit(0);
            }
            System.out.println("Enter a degree. . .");
            int degree = input.nextInt();
            if (degree == 0){
                System.out.println("Improper input");
                System.exit(0);
            }
            try{
                List<String> list = proDict.findRhymingSynonyms(rootWord, rhymeWord, degree);
                for (int i = 0; i < list.size(); i++){
                    System.out.print(list.get(i) + " ");
                }
            } catch (ThesaurusException error) {
                System.out.println("Word could not be found");
            }
            System.out.println();
            
        }
    }
}
