import java.util.Scanner;
public class Program1 {
	public static void main(String[] args){
		System.out.println("Enter five rows with five numbers in each row:");
        Scanner input = new Scanner(System.in);
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                array[i][j] = input.nextInt();
            }
        }
        sumRowsAndCols(array);
        }
	private static void sumRowsAndCols(int[][] array){
		for (int iteration = 1; iteration >= 0; iteration--)
        {
           System.out.print("\n");
            for (int i = 0; i < array.length; i++)
            {
                int sumTemp = 0;
                for (int j = 0; j < array[i].length; j++)
                    {
                        sumTemp += iteration == 1 ? array[i][j] : array[j][i];
                    }
                System.out.print(sumTemp + " ");
            }
        }
	}
}
