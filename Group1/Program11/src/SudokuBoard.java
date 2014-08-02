
public class SudokuBoard {
	int[][] board = new int[9][9];
    int[] availableNumbers = {9,9,9,9,9,9,9,9,9}; //literal notation for an array of 9 9's
    final int EMPTY = -1; //sets constant
    
    public SudokuBoard(int[][] fixedSquares){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = EMPTY; //sets every cell on board to empty
            }
        }
        for (int i = 0; i < fixedSquares.length; i++){
            for (int j = 0; j < fixedSquares[i].length; j++){
                if (fixedSquares[i][j] > 0){ 
                    board[i][j] = (fixedSquares[i][j] - 1); //sets the board equal to the fixedSquare number - 1
                    if (!(availableNumbers[board[i][j]] > 0) || !(isOk(i,j))){ //if that number is not still available or is not able to be placed because it is against the rules
                        throw new IllegalArgumentException(i + ", " + j + " is not available");
                    }
                    else {//.. if so:
                        availableNumbers[board[i][j]]--; //decrements that number in the available numbers
                   }
                }

            }
        }
    }
    
    public void print(){ //just prints the entire board by traversing the 2d array, elementary at this point
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                System.out.print((board[i][j] + 1) + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    
    private boolean noNumbersLeft(){
        for (int i = 0; i < availableNumbers.length; i++){
            if (availableNumbers[i] != 0){
                return false; //if ANY number is still available, false is returned 
            }
        }
        return true;
    }
    
    private boolean isOk(int r, int c){ //checks rows separately to ensure move is in line with rules
        for (int row = 0; row < board.length; row++){
            if (board[row][c] == board[r][c] && row != r){
                return false;
            }
        }
        for (int col = 0; col < board.length; col++){ //checks columns separately to make sure it is within the rules
            if (board[r][col] == board[r][c] && col != c){
                return false;
            }
        }
        
        for (int rTemp = (r/3)*3; rTemp < (r/3)*3 + 3; rTemp++){ //this checks the 3x3 square for duplicates, 
            for (int cTemp = (c/3)*3; cTemp < (c/3)*3 + 3; cTemp++){
                if ((board[rTemp][cTemp] == board[r][c]) && ((r != rTemp) && (c != (cTemp)))){ //returns false if the current value being tested equals the value of the number just placed and is not at the same index
                    return false;
                }
            }
        }
        return true; //returns true otherwise
    }
    public boolean solve(){
        if (noNumbersLeft()){
            return true; //if no numbers are left, it is "solved" as much as possible
        }
        else{
            for (int row = 0; row < board.length; row++){
                for (int col = 0; col < board[row].length; col++){ //iterates until it finds an empty cell
                    if (board[row][col] == EMPTY){ //if the cell is empty
                        for (int i = 0; i < availableNumbers.length; i++){ //iterates through the available numbers
                            if (availableNumbers[i] > 0){ //if a number is available
                                board[row][col] = i; //the number is set to the spot on the board
                                if (isOk(row,col)){ //if it is okay
                                    availableNumbers[i]--; //the number's quantity is decremented by 1 from availableNumbers
                                    if (solve()){ //this is also the only time solve is called recursively
                                        return true;
                                    }
                                    else{
                                        availableNumbers[i]++; //increments the available numbers quantity
                                   }
                                }
                            }
                        }
                         board[row][col] = EMPTY; //the position is set to empty
                         return false;
                        }
                    }
                }
            }
        return false;
        }

}
