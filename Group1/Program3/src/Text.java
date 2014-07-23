
public class Text {
	private String str;
    private  int wordCount = 0;
    private int sentenceCount = 0;
    private String[] words;
    
    public String[] getWords(){
        return words;
    }
    
    public int getWordCount(){
        return wordCount;
    }
    
    public int getSentenceCount(){
        return sentenceCount;
    }
    
    public Text(String g){
        str = g;
        calculateStats();
    }
    
    private void calculateStats()
    {
        words = str.split("(\\s+)"); //recognizes all whitespace chars
        for (int i = 1; i >= 0; i--)
            {
            for (int j = 0; j < words.length; j++)
                {
                if (i == 1 && words[j].matches(".+[,|;|:]+"))
                    {
                        words[j] = words[j].substring(0, words[j].length() - 1);
                    }
                else if (i == 0 && words[j].matches(".+[!|//?|//.]+"))
                    {
                        words[j] = words[j].substring(0, words[j].length() - 1);
                       sentenceCount++;
                    }     
                }
            }
        wordCount = words.length;
    }
}
