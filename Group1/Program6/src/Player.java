
public class Player {
	public static final int HIT= 1;
    public static final int STAY= 0;
    protected Hand hand = new Hand();
    protected String name;
    
    public Player(String name){
        this.name = name;
    }
    public void acceptCard(Card card){
        hand.acceptCard(card);
    }
    public int handValue(){
        if (hand.softValue() <= 21){
            return hand.softValue();
        }
        else{
            return hand.hardValue();
        }
    }
    public String getName(){
        return this.name;
    }
    public int nextAction(){
        return 0;
    }
    @Override
    public String toString(){
        return hand.toString();
    }

}
