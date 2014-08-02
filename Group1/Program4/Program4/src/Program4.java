/*Program takes in two arguments, one is a single integer
 * (order) that forms a grid with the dimensions order*order and fills it with blank
 * or '*' characters. The second argument contains a list of words that are to
 * be placed into the grid at random locations at random locations in order to
 * form a wordsearch puzzle. If a word cannot be placed in due to overcrowding,
 * the program will not continue. After all words are placed in the array, all
 * remaining '*' characters are replaced with random letters of the alphabet.
 * The program prints out the board with just the words from the list in it and
 * then the board with all blanks replaced with random letters. */

public class Program4 {
	public static void main(String[] args) 
    {
        int order = 0;
        String fileName = null;
        if (args.length < 2)
        {
             System.out.println("Usage: wordsearch <order> <wordfilename>");
            return;
        } 
        else 
        {
            try 
            {
                order = Integer.parseInt(args[0]);
            } 
            catch (Exception ex)
            {
                System.out.println("Invalid order: " + args[0]);
                return;
            }
            fileName = args[1];
        }
        Puzzle p = new Puzzle(order, fileName);
        if (p.createPuzzle()) 
        {    
            p.display();
            p.fillRandom();
            p.display();
        }
        else
        {
            System.out.println("Can't create puzzle.");
        }        
    }

}
