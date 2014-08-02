import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PronouncingDictionary {
	Thesaurus thesaurus = new Thesaurus("mthesaurEDIT.txt");
    private Map<String, ArrayList<String>> wordList = new HashMap<>();
    private Map<String, Boolean> isVowel = new HashMap<>();
    
    public PronouncingDictionary(String wordlistFile, String phonemeFile){
        try {   
        BufferedReader input = new BufferedReader(new FileReader(wordlistFile));
            String line;
            while ((line = input.readLine()) != null )
            {
                if (line.substring(0,2).contains(";;;")){
                    continue;
                }
                line = line.trim();
                ArrayList<String> phonemeList = new ArrayList<>();
                String[] tempWords = line.split("\\s+");
                for (int i = 1; i < tempWords.length; i++){
                    phonemeList.add(tempWords[i]); 
                }
                wordList.put(tempWords[0],phonemeList);
            }
        }
        catch (IOException ex)
        {
            System.out.println("There was an error in BufferedReader, check input file(s)");
            System.exit(0);
        }  
        try {   
        BufferedReader input = new BufferedReader(new FileReader(phonemeFile));
            String line;
            while ((line = input.readLine()) != null )
            {
                line = line.trim();
                String[] tempWords = line.split("\\s+");
                boolean vowel = false;
                if (tempWords[1].trim().equals("Vowel")){
                    vowel = true;
                }
                isVowel.put(tempWords[0],vowel);
            }
        }
        catch (IOException ex)
        {
            System.out.println("There was an error in BufferedReader, check input file(s)");
            System.exit(0);
        }  
    }
    public int rhymePhoneCount(String word1, String word2){
        int matchingVowels = 0;
         
        if (wordList.get(word1) == null){
            return 0;
        }
        else if (wordList.get(word2) == null){
            return 0;
        }
        
        ArrayList<String> wordList1 = wordList.get(word1.toUpperCase());        
        ArrayList<String> wordList2 = wordList.get(word2.toUpperCase());

        int shortestWord = wordList1.size();
        if (shortestWord > wordList2.size()){
            shortestWord = wordList2.size();
        }
        
        for (int i = 1; i < shortestWord; i++)
        {
            String currentPhone1 = wordList1.get(wordList1.size()-i);
            String currentPhone2 = wordList2.get(wordList2.size()-i);
            if (currentPhone1.equalsIgnoreCase(currentPhone2)){
                if (currentPhone1.length() == 3){
                    currentPhone1 = currentPhone1.substring(0, 2);
                }
                if (isVowel.get(currentPhone1) == true){
                    matchingVowels++;
                }
            }
            else{
                return matchingVowels;
            }  
        }
        return matchingVowels;
    }

    public List<String> findRhymingSynonyms(String rootWord, String rhymeWord, int degree) throws ThesaurusException{
        List<String> synonymList = thesaurus.getSynonyms(rootWord.toLowerCase());
        List<String> matchingWords = new ArrayList<>();

        if (thesaurus.getSynonyms(rootWord) == null){
            throw new ThesaurusException(rootWord + " does not exist");
        }
        else if (thesaurus.getSynonyms(rhymeWord) == null){
            throw new ThesaurusException(rhymeWord + " does not exist");
        }
        for (int i = 0; i < synonymList.size(); i++){
            if (rhymePhoneCount(synonymList.get(i).toUpperCase(),rhymeWord.toUpperCase()) >= degree){
                matchingWords.add(synonymList.get(i));
            }
        }
        return matchingWords;
    }

}
