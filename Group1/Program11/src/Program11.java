

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program11 {
	public static void main(String[] args) {
        /*args include filename
        /*it is assumed that file is in the format:
        * 1 2 3
        * 1 2 3
        * 1 2 3
        * lines will be split based on spacial characters, not commas.
        */
         if (args.length < 1){
             System.out.println("Prog11 arg should be sudokuPuzzle.txt");
         }
         else{
            int[][] init = new int[9][]; //note: directions instruct to create it with fixed cells, so I assume 9x9, see below
            String fileName = args[0];
            try{ //makes sure the file name is legitimate

                BufferedReader in = new BufferedReader(new FileReader(fileName)); //reads in the filename
                String currentLine;
                int currentIndex = 0;
                 while ((currentLine = in.readLine()) != null ){ //while the currentLine is not null
                  String[] lineFields = currentLine.trim().split("\\s+"); //splits into an array of strings based on any spacial character
                  int[] lineInts = new int[lineFields.length]; //creates an array of integers, where the strings will be parsed and placed
                  
                  for (int i = 0; i < lineInts.length; i++){
                      lineInts[i] = Integer.parseInt(lineFields[i]); //parses each string into an int and puts them into the int array
                  }
                  if (lineInts.length == 9){ //NOTE: not completely necessary, but makes sure the array is not jagged
                  init[currentIndex] = lineInts; //puts the entire array of ints onto the specified line of init
                  }
                  currentIndex++; //increments the index position (in init)
                  
                  if (currentIndex > 8){ //NOTE: I know this is not completely necessary, but will ensure the init array caps at 9 lines and does not go out of bounds
                      break;
                  }
                 
                }
                
            }
            catch(IOException ex){ //if there is an IOException
                System.out.println("There was an error, check input file");
                System.exit(0);
            }

            SudokuBoard sb = new SudokuBoard(init);
        
            sb.print(); //prints unsolved board
        
            if (sb.solve()){
            sb.print(); //prints solved board
            }
            else{
            System.out.println("No solution.");
            }
         }
        
    }

}
