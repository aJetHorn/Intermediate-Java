import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordList {
	private Word[] words;
    private String file;
    
    public WordList(String fileName)
    {
        file = fileName;
        readFile();
    }
    public boolean readFile()
    {
        ArrayList<String> wordList = new ArrayList<String>();
        //ArrayList used to make it easier to add strings to the array
        //and increment the size without having to create a new array each time
        try 
        {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String line;
            while ((line = input.readLine()) != null )
            {
                wordList.add(line.trim()); //adds word to array list
            }
        }
        catch (IOException ex)
        {
            System.out.println("There was an error in BufferedReader, check input file(s)");
            return false;
        }
        words = new Word[wordList.size()]; //sets words to the size of the ArrayList
        
        String[] sortedWords = new String[wordList.size()]; //begins sorting array
        for (int i = 0; i < sortedWords.length; i++)
        { 
            sortedWords[i] = wordList.get(i);
            if (i != 0) //ensures the index being tested is at least the second
            {
                if (sortedWords[i].length() > sortedWords[i - 1].length())
                    //above statement starts loop if the current word is longer
                    //than the word before it
                {
                    int y;
                    int iTemp = i;
                    for (y = i - 1; y >= 0; y--) //main sorting loop
                    {
                        y = i - 1;
                        if (sortedWords[y].length() < sortedWords[i].length())
                        {
                            String temp = sortedWords[y];
                            String temp2 = sortedWords[i];
                            sortedWords[y] = temp2;
                            sortedWords[i] = temp;
                        }
                        i = y; //sets i to y as earlier words are tested for swaps
                    }
                    i = iTemp; //resets i
                }
            }
        }
        
        for (int i = 0; i < sortedWords.length; i++)
        {
            words[i] = new Word(sortedWords[i]);
            //sets an index in words to a new word object from a string from
            //sortedWords of the same index i
        }  
        return true; //false if false, read in file
    }
    public Word[] getList()
    {
        return words;
    }

}
