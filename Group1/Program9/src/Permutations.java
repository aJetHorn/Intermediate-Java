import java.util.Arrays;

public class Permutations {
	int[] currentPerm;
    int numPerm;
    Permutation[] permArray;
    
    public Permutations(int[] intArray){
        currentPerm = intArray; 
        int factorial = currentPerm.length;
        for (int i = currentPerm.length - 1; i > 1; i--){
            factorial *= i;
        }
        permArray = new Permutation[factorial]; //ask in class
        permArray[0] = new Permutation(currentPerm);   
    }
    
    public void rotate(int i1, int i2){
        int temp = currentPerm[i2]; 
        for (int i = i2; i > i1; i--){
            currentPerm[i] = currentPerm[i - 1];         
        }
        currentPerm[i1] = temp;
    }
    
    private void permute(int n){ //recursive method
        if (n == currentPerm.length - 1){
            permArray[numPerm] = new Permutation(currentPerm);
            numPerm++;
        }
        else{  
            for (int i = n; i < currentPerm.length; i++){
                permute(n + 1); //recursion through calling the method with n+1
                rotate(n,currentPerm.length-1);
            }                  
        }
    }
    public Permutation[] permute(){
        permute(0);
        return permArray;
    }

}
