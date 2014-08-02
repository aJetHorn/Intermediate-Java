import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Thesaurus {
private Map<String,ArrayList<String>> synonyms = new HashMap<>();
    
    public Thesaurus(String fileName){
        try 
        {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = input.readLine()) != null )
            {
                ArrayList<String> synonymList = new ArrayList<>();
                String[] tempWords = line.split(",");
                for (int i = 1; i < tempWords.length; i++){
                    synonymList.add(tempWords[i].trim()); 
                }
                synonyms.put(tempWords[0],synonymList);
            }
        }
        catch (IOException ex)
        {
            System.out.println("There was an error in BufferedReader, check input file(s)");
            System.exit(0);
        }  
    }
    public List<String> getSynonyms(String lookupWord) throws ThesaurusException{
        if (synonyms.get(lookupWord) == null){
            throw new ThesaurusException(lookupWord +  " does not exist");
        }
        return synonyms.get(lookupWord);
    }

}
