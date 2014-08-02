import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RealPlayer extends Player{
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public RealPlayer(String name) {
        super(name);
    }
    @Override
    public int nextAction() {
        for (;;) {
            try {
                System.out.println("Enter h to hit, s to stay: ");
                String answer = in.readLine();
                if (answer.equals("h")) {
                    return Player.HIT;
                } else if (answer.equals("s")) {
                    return Player.STAY;
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.exit(-1);
            }
} }

}
