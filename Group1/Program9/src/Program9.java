
public class Program9 {
	public static void main(String[] args) { //code provided
        int[] a;
        if (args.length < 1){
            System.out.println("Integer required on command line.");
            System.exit(1);
        }
        int n = Integer.parseInt(args[0]);
        a = new int[n];
        for (int i = 0; i < n; ++i){
            a[i] = i + 1;     
        }
        Permutations perm = new Permutations(a);
        Permutation[] perms = perm.permute();
        for (Permutation p : perms){
            System.out.println(p.toString());
        }
        System.out.println();
        bubbleSort(perms);
        for (Permutation p : perms){
            System.out.println(p.toString());
        }
    }
    private static void bubbleSort(Comparable[] a){ //bubblesort sorting algorithm
        
        int length = a.length;
        boolean continueSort = true;
        
        while (continueSort){
            length--;
            continueSort = false;          
            for (int i = 0; i < length; i++){
                if (a[i].compareTo(a[i]) > a[i+1].compareTo(a[i])){
                    Comparable x = a[i];
                    a[i] = a[i + 1];
                    a[i+1] = x;
                    continueSort = true;
                }
            }
        }
    }

}
