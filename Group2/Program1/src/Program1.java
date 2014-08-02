import java.util.Scanner;

public class Program1 {
	public static void main(String[] args) {
        char [][] startBoard = new char[3][3];
        boolean player = true;
        createBoard(startBoard);
        do {
             player = !player; //switch the player 
             displayNewBoard(changePlayer(player), inputCheck(changePlayer(player)), startBoard);
             //display the new game board after a player move
        }
        while(checkWin(startBoard, changePlayer(player)) == false); //check if there is a winner yet
   }
   
   /** This method creates and prints the initial game board.*/
   public static void createBoard(char[][] startBoard) {
        startBoard[0][0] = '1';
        startBoard[0][1] = '2';
        startBoard[0][2] = '3';
        startBoard[1][0] = '4';
        startBoard[1][1] = '5';
        startBoard[1][2] = '6';
        startBoard[2][0] = '7';
        startBoard[2][1] = '8';
        startBoard[2][2] = '9';
        
        for(int i=0; i<3; i++) {
             for(int j=0; j<3; j++) {
                  System.out.print(startBoard[i][j] + " ");
             }
             System.out.println();   
        }
        System.out.println();   
   }
   
   public static void displayNewBoard(char player, int value, char[][] board) {

        while(value == 0) {
             System.out.println("Invalid entry. Try again.\n");
             for(int i=0; i<3; i++)
             {
                  for(int j=0; j<3; j++) 
                  {
                       System.out.print(board[i][j] + " ");
                  }
                  System.out.println();   
             }
             System.out.println();
             value = inputCheck(player);               
        }
        
        if(value == 1 && board[0][0] != 'X' && board[0][0] != 'O'){
        	board[0][0] = player;
        }                                      
        else if (value == 2 && board[0][1] != 'X' && board[0][1] != 'O'){
            board[0][1] = player;
        }
        else if (value == 3 && board[0][2] != 'X' && board[0][2] != 'O'){
            board[0][2] = player;
        }
        else if (value == 4 && board[1][0] != 'X' && board[1][0] != 'O'){
            board[1][0] = player;
        }
        else if (value == 5 && board[1][1] != 'X' && board[1][1] != 'O'){
            board[1][1] = player;
        }
        else if (value == 6 && board[1][2] != 'X' && board[1][2] != 'O'){
            board[1][2] = player;
        }
        else if (value == 7 && board[2][0] != 'X' && board[2][0] != 'O'){
            board[2][0] = player;
        }
        else if (value == 8 && board[2][1] != 'X' && board[2][1] != 'O'){
            board[2][1] = player;
        }
        else if (value == 9 && board[2][2] != 'X' && board[2][2] != 'O'){
            board[2][2] = player;
        }
        else {
             System.out.println("There is already a token there");
             //System.exit(0);
        }
        
        //prints the new board
        System.out.println();
        for(int i=0; i<3; i++) {
             for(int j=0; j<3; j++) {
                  System.out.print(board[i][j] + " ");
             }
             System.out.println();   
        }
        System.out.println();   
   }
   
   public static int inputCheck(char player) {
        System.out.println("Enter the number (1-9) to where the " + player + " will be entered.");
        Scanner input = new Scanner(System.in);
        int value = 0;
        
        if(input.hasNextInt()){
             value = input.nextInt();
             if(value < 1 || value > 9) {
                  return 0;
             }
             else{
            	 return value;  
             }             
        }
        return 0;
   }
   
   public static char changePlayer(boolean player) {
        char playerChar = ' ';
        if(player){
        	playerChar = 'X';     
        }

        else
             playerChar = 'O';
        return playerChar;      
   }
   
   public static boolean checkWin(char[][] board, char player) {
        for(int i=0; i<3; i++) 
        {
             for(int j=0; j<3; j++) 
             {
                  //this if block makes sure that there are still playable positions on the board
                  if(board[0][0] == '1' || board[0][1] == '2' || board[0][2] == '3' || 
                     board[1][0] == '4' || board[1][1] == '5' || board[1][2] == '6' ||
                     board[2][0] == '7' || board[2][1] == '8' || board[2][2] == '9') 
                  {
                       //checks for horizontal win
                       if(board[0][j] == player && board[1][j] == player && board[2][j] == player)  
                       {
                            System.out.println("Game over, player " + player + " wins!");
                            return true;
                       }
                       //checks for vertical win
                       else if(board[i][0] == player && board[i][1] == player && board[i][2] == player)
                       {
                            System.out.println("Game over, player " + player + " wins!");
                            return true;
                       }
                       //checks for diagonal win
                       else if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
                       {
                            System.out.println("Game over, player " + player + " wins!");
                            return true;
                       }
                       //checks for diagonal win
                       else if(board[2][0] == player && board[1][1] == player && board[0][2] == player)
                       {
                            System.out.println("Game over, player " + player + " wins!");
                            return true;
                       }
                  }
                  else 
                  {
                       System.out.println("The game has ended in a draw.");
                       return true;
                  } 
             } 
        } 
        return false; 
   } 
}
