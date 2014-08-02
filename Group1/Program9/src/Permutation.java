import java.util.Arrays;

public class Permutation implements Comparable<Permutation>{
private int[] intList;
    
    public Permutation(int[] array){
        intList = Arrays.copyOf(array, array.length);
    }

    @Override
    public int compareTo(Permutation perm){ //override compareTo method
        int[] list1 = this.intList;
        int[] list2 = perm.intList;
        
        for (int i = 0; i < list1.length; i++){
            if (list1[i] > list2[i]){
                return 1;
            }
            else if (list1[i] < list2[i]){
                return -1;
            }
        }
        return 0;
    }
    
    @Override
    public String toString(){ //toString method overridden to return a string with all element
        String elementList = "";
        for (int i = 0; i < intList.length; i++){
            elementList += intList[i] + " ";
        }
        return elementList;
    }

}
