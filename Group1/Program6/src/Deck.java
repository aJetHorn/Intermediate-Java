import java.util.Random;
public class Deck {
	private Card[] cards = new Card[52];
    private int nextCard;
    private java.util.Random rand;
    
    public Deck(){
            for (int g = 0, i = 0; g < 4; g++){
                for (int p = 0; p < 13; p++){
                    cards[i] = new Card(p, g);
                    i++;
                }
            }
        rand = new java.util.Random();
    }
    public void shuffle(){
        for (int i = 0; i < 52; i++){
            nextCard = (rand.nextInt(51) + 1);
            Card temp = cards[0];
            cards[0] = cards[nextCard];
            cards[nextCard] = temp;
            nextCard = 0;
        }
    }
    public Card dealCard(){
        return cards[nextCard++];
    }
    public int getCardsRemaining(){
        return 52 - nextCard;
    }

}
