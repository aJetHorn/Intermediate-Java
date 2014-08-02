
public class Word {
	private String word;
    private int column;
    private int row;
    private int direction;
    
    public Word(String word)
    {
     this.word = word.toUpperCase(); 
     column = 0;
     row = 0;
     direction = 0;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    

}
