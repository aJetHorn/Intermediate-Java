
public class Card {
	private int rank = 0;
    private int suit = 0;
    private static String[] rankNames = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private static String[] suitNames = {"C","H","S","D"};
    public static final int CLUBS = 0;
    public static final int HEARTS = 1;
    public static final int SPADES = 2;
    public static final int DIAMONDS = 3;
    public static final int ACE = 0;
    public static final int TWO = 1;
    public static final int THREE = 2;
    public static final int FOUR = 3;
    public static final int FIVE = 4;
    public static final int SIX = 5;
    public static final int SEVEN = 6;
    public static final int EIGHT = 7;
    public static final int NINE = 8;
    public static final int TEN = 9;
    public static final int JACK = 10;
    public static final int QUEEN = 11;
    public static final int KING = 12;    
    
    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }
    public int getRank(){
        return this.rank;
    }
    public int getSuit(){
        return this.suit;
    }   
    public String getRankName(){
        return rankNames[rank];
    }
    public String getSuitName(){
        return suitNames[suit];
    }
    @Override
    public String toString(){
        return getRankName() + getSuitName();
    }
    @Override
    public boolean equals(Object x){
        if (x instanceof Card) {
            Card card = (Card)x; 
            if (card.getRank() == rank && card.getSuit() == suit){
                return true;
            }            
        }
        return false;
    }

}
