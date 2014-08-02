
public class Puzzle {
	private char[][] wordSearch;
    private String fileName;
    private int order;
    private final char BLANK = '*';

    public Puzzle(int order, String fileName) 
    {
        this.fileName = fileName;
        this.order = order;
        wordSearch = new char[order][order];
        for (int x = 0; x < wordSearch.length; x++)
        {
            for (int y = 0; y < wordSearch[x].length; y++)
            {
                wordSearch[x][y] = BLANK;
            }
        }
    }

    private int pickRow() 
    {
        return (int) ((order - 1) * Math.random());
    }

    private int pickCol()
    {
        return (int) ((order - 1) * Math.random());
    }

    private boolean check(Word word, int row, int col, int direction) {
        int x = row;
        int y = col;
        for (int charAtLocation = 0; charAtLocation < word.getWord().length(); charAtLocation++)
        {
            if (x >= order || y >= order || y < 0 || x < 0)
            {
                return false;
            }
            if (wordSearch[x][y] != word.getWord().charAt(charAtLocation) && wordSearch[x][y] != BLANK)
            {
                return false;
            }
            switch (direction) {
                case 0:
                    y += 1;
                    break;
                case 1:
                    x += 1;
                    y += 1;
                    break;
                case 2:
                    x += 1;
                    break;
                case 3:
                    x += 1;
                    y -= 1;
                    break;
                case 4:
                    y -= 1;
                    break;
                case 5:
                    x -= 1;
                    y -= 1;
                    break;
                case 6:
                    x -= 1;
                    break;
                case 7:
                    x -= 1;
                    y += 1;
                    break;
            }
        }
        return true;
    }

    private void place(Word word, int row, int col, int direction)
    {
        int x = row;
        int y = col;
        for (int charAtLocation = 0; charAtLocation < word.getWord().length(); charAtLocation++)
        {
            wordSearch[x][y] = word.getWord().charAt(charAtLocation);
            switch (direction) 
            {
                case 0:
                    y += 1;
                    break;
                case 1:
                    x += 1;
                    y += 1;
                    break;
                case 2:
                    x += 1;
                    break;
                case 3:
                    x += 1;
                    y -= 1;
                    break;
                case 4:
                    y -= 1;
                    break;
                case 5:
                    x -= 1;
                    y -= 1;
                    break;
                case 6:
                    x -= 1;
                    break;
                case 7:
                    x -= 1;
                    y += 1;
                    break;
            }
        }
    }

    private boolean attemptPlaceWord(Word word) {
        int[][] triedArray = new int[order][order];
        for (int positionsTried = 0; positionsTried < order * order; positionsTried++) {
            int row = pickRow();
            int col = pickCol();
            while (triedArray[row][col] == 1) {
                row = pickRow();
                col = pickCol();
            }
            int[] triedDirectionsArray = new int[8];
            for (int directionsTried = 0; directionsTried < 7; directionsTried++) {
                int direction = (int) (Math.random() * 7);
                while (triedDirectionsArray[direction] == 1) {
                    direction = (int) (Math.random() * 7);
                }

                if (check(word, row, col, direction)) {
                    place(word, row, col, direction);
                    return true;
                } else {
                    triedDirectionsArray[direction] = 1;

                }
            }
            triedArray[row][col] = 1;
        }
        return false;
    }

    public void fillRandom() {
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int x = 0; x < wordSearch.length; x++) {
            for (int y = 0; y < wordSearch[x].length; y++) {
                if (wordSearch[x][y] == BLANK) {
                    wordSearch[x][y] = alphabet[(int) (25 * Math.random())];
                    //randomly chooses a letter
                }
            }
        }
    }

    public void display() {
        for (int x = 0; x < wordSearch.length; x++) {
            for (int y = 0; y < wordSearch[x].length; y++) {
                System.out.print(wordSearch[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public boolean createPuzzle() {
        WordList theWordList = new WordList(fileName);
        Word[] wordsCopy = new Word[theWordList.getList().length];
        for (int i = 0; i < wordsCopy.length; i++) {
            wordsCopy[i] = theWordList.getList()[i];
        }
        for (int i = 0; i < wordsCopy.length; i++) {
            if (!attemptPlaceWord(wordsCopy[i])) {
                return false;
            }
        }
        return true;
    }

}
