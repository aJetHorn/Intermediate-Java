import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Program6 {
	private static Deck deck = new Deck();
    public static void main(String[] args) {
        deck.shuffle();
        Dealer dealer = new Dealer("Danny the Dealer");
        List<Player> players = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("What is your name? ");
        String name = null;
        try {
            name = in.readLine();
        } catch (IOException ex) {
            name = "Bozo";
        }
        if (name.length() == 0)
            name = "Bozo";
        players.add(new AlwaysStayPlayer("Always Stay Alan"));
        players.add(new AlwaysStayPlayer("Always Stay Alice"));
        players.add(new HitTil21Player("Hit Til 21 Harry"));
        players.add(new HitTil21Player("Hit Til 21 Helen"));
        players.add(new RealPlayer(name));
        
        for (Player player : players) {
            playHand(player);
        }
        playHand(dealer);
        if (dealer.handValue() > 21) {
            for (Player player : players) {
                if (player.handValue() <= 21) {
                    System.out.printf("%s Wins!\n", player.getName());
                } 
            }
        } else {
            for (Player player : players) {
                if (player.handValue() <= 21 && player.handValue() > dealer.handValue()) {
                    System.out.printf("%s Wins!\n", player.getName());
                }
            }    
        }
    }
    public static void playHand(Player player) {
        while (player.nextAction() == Player.HIT) {
            System.out.printf("%s Hits\n", player.getName());
            Card card = deck.dealCard();
            System.out.printf("...gets a %s\n", card);
            player.acceptCard(card);
        }
        System.out.printf("%s Stays\n", player.getName());
        if (player.handValue() > 21) {
            System.out.printf("%s is busted!\n", player.getName());
        }
        System.out.println();
    }

}
