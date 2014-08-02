
public class HitTil21Player extends Player{
    
    public HitTil21Player(String name) {
      super(name);
}
  @Override
  public int nextAction(){
      if (hand.softValue() < 21 && hand.hardValue() < 21){
          return Player.HIT;
      }
      return Player.STAY;
  }
}
