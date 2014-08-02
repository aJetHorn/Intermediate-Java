import java.util.ArrayList;
import java.util.List;

public class Hand {
List<Card> cards = new ArrayList<>();
    
    public Hand(){      
    } 
    
    @Override
    public String toString(){
        String returnString = cards.get(0).toString();
        for (int i = 1; i < cards.size(); i++){
            returnString += cards.get(i).toString() + " ";
        }
        return returnString;
    }
    
    public int hardValue(){
        int totalValue = 0;
        for (int i = 0; i < cards.size(); i++){
            totalValue += (cards.get(i).getRank() + 1);
        }                    
        return totalValue;
    }
    
    public int softValue(){
        int totalValue = 0;
        for (int i = 0; i < cards.size(); i++){
            if (cards.get(i).getRank() == 0){
                totalValue += 10;
            }
            totalValue += (cards.get(i).getRank() + 1);
        }
        return totalValue;
    }
    
    public void acceptCard(Card c){
        if (c == (null)){
            throw new IllegalArgumentException("Card cannot be null");
        }
        else{
            cards.add(c); 
        }
    }

}
