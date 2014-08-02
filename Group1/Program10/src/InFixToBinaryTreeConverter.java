import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InFixToBinaryTreeConverter {
	List<String> inFix;
    List<String> stack;
    List<Node> btstack;
    String expression;
    
    public InFixToBinaryTreeConverter(){
        inFix = new LinkedList<>();
        stack = new ArrayList<>();
        btstack = new ArrayList<>();
    }
    
    public void run(String s){
        this.expression = s;
        System.out.println(expression); //just prints expression
        createInFix(expression); //makes the expression a linkedlist
        
        Node btNode = createBinaryTree(); //sets the stack and btstack to the infix
        
        System.out.println(btNode.toString());  
        //Note: I asked about the correctness of the order below in class,
        //since it did not match "inorder,preorder,postorder" from the directions but did match the print output,
        //I just left it so that it still printed the correct lines as the instructions. Clearly,
        //all of the methods are correct. 
        System.out.println(preorder(btNode)); //returns preorder string and prints it
        System.out.println(inorder(btNode));  //returns inorder string and prints it
        System.out.println(postorder(btNode));  //returns postorder string and prints it

        System.out.println(optimize(btNode)); //prints out the result
    }
    
    public void createInFix(String x){
        String[] symbolArray = x.split("\\s+"); //splits string into array on any spacial character
        for (int i = 0; i < symbolArray.length;i++){ //loops through length
            inFix.add(symbolArray[i]); //adds each element
        }
    }
    public Node createBinaryTree(){
        stack.add(0, "(");
        inFix.add(")");
        while (!inFix.isEmpty()){ //runs as long as inFix has something in it
            //dequeue from left to right, that means remove as you go
                String currentSymbol = inFix.remove(0);
                
                if (isNumber(currentSymbol)){
                    Node newNode = new Node(currentSymbol, null, null);
                    btstack.add(newNode); 
                }
                else if (isLParen(currentSymbol)){
                    stack.add(currentSymbol);
                }
                else if (isOperator(currentSymbol)){
                    while (isOperator(stack.get(stack.size()-1)) && isHigherPrecedence(currentSymbol, stack.get(stack.size()-1))){
                        
                        Node a = btstack.remove(btstack.size()-1);
                        Node b = btstack.remove(btstack.size()-1);
                        
                        Node newNode =  new Node(stack.remove(stack.size()-1), b, a);
                        btstack.add(newNode);
                    }
                    stack.add(currentSymbol);
                }       
                else if (isRParen(currentSymbol)){
                    while (!isLParen(stack.get(stack.size()-1))){

                        Node a = btstack.remove(btstack.size()-1);
                        Node b = btstack.remove(btstack.size()-1);

                        Node newNode =  new Node(stack.remove(stack.size()-1), b, a);
                        btstack.add(newNode);
                    }
                    stack.remove(0);
                }
        }
        return btstack.remove(0);
    } //runs well
     
     public boolean isNumber(String x){
         //below conditional tests if "x" contains anything other than a number, and returns false accordngly
         if (x.equals(")") || x.equals("(") || x.equals(",") || x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")){
             return false;
         }
     return true;
    }
     public boolean isOperator(String x){ //tests if the string is one of the four basic arithmatic operators
         
         if (x.equals("+") || x.equals("-") || x.equals("/") || x.equals("*")){
             return true;
         }
         //returns true if the string is an operator
         return false;
     }
     public boolean isLParen(String x){
         if (x.equals("(")){
             return true;
         }
         return false;
     }
     public boolean isRParen(String x){
         if (x.equals(")")){
             return true;
         }
         return false;
     }
     public boolean isHigherPrecedence(String op1, String op2){
         //some confusion with this method- the upper portion of the directions instructs
         //to check only for a greater-than condition, but later in the instructions
         //it also says to check for equal-to. I have written this in accordance
         //with the latter instruction, and returned true if it is equal to
         if ((op2.equals("*") || op2.equals("/")) && (op1.equals("+") || op1.equals("-"))){
             return false;
         }
         return true;
     }
     //optimize will completely evaluate the tree and, if successful, will return
     //a node containing a single number, which is equivalent to all of the nodes
     //being evaluated in proper order
     public Node optimize(Node node){  
         if (node == null){
             return null;
         } else{
             node.leftChild = optimize(node.leftChild);
             node.rightChild = optimize(node.rightChild);
             
             if (node.element.equals("*") && (node.rightChild.element.equals("0")|| node.leftChild.element.equals("0"))){
                 node.element = "0"; //checks if mulyiplied by 0
                 node.leftChild = null;
                 node.rightChild = null;
             }
             else if (node.element.equals("*") && (node.rightChild.element.equals("1")|| node.leftChild.element.equals("1"))){
                 if (node.rightChild.element.equals("1")){ //checks if multiplied by 1
                     node.element = String.valueOf(node.leftChild);
                     node.leftChild = null;
                     node.rightChild = null;
                 }
                 else{
                     node.element = String.valueOf(node.rightChild);
                     node.leftChild = null;
                     node.rightChild = null;
                 }     
             }
             //the three conditionals below will parse the strings to integers and apply appropriate operations
             else if (node.element.equals("*") && (isNumber(node.rightChild.element) && isNumber(node.leftChild.element))){
                 node.element = String.valueOf(Integer.parseInt(node.leftChild.element) * Integer.parseInt(node.rightChild.element));
                 node.leftChild = null;
                 node.rightChild = null;
             } 
             else if (node.element.equals("/") && (isNumber(node.rightChild.element) && isNumber(node.leftChild.element))){
                 node.element = String.valueOf(Integer.parseInt(node.leftChild.element) / Integer.parseInt(node.rightChild.element));
                 node.leftChild = null;
                 node.rightChild = null;
             } 
             else if (node.element.equals("+") && (isNumber(node.rightChild.element) && isNumber(node.leftChild.element))){
                 node.element = String.valueOf(Integer.parseInt(node.leftChild.element) + Integer.parseInt(node.rightChild.element));
                 node.leftChild = null;
                 node.rightChild = null;
             } 
             else if (node.element.equals("-") && (isNumber(node.rightChild.element) && isNumber(node.leftChild.element))){
                 node.element = String.valueOf(Integer.parseInt(node.leftChild.element) - Integer.parseInt(node.rightChild.element));
                 node.leftChild = null;
                 node.rightChild = null;
             } 
         }
         return node;
         
     }

       public String preorder(Node node){ //returns a string containing the nodes in the proper order according to preorder
        if (node != null){
            return node.element + " " + preorder(node.leftChild) + preorder(node.rightChild);
        }
        return "";
    }
       public String inorder(Node node){ //returns a string containing the nodes in the proper order according to inorder
        if (node != null){
            return inorder(node.leftChild) +  node.element + " " + inorder(node.rightChild);
        }
        return "";
    }
    public String postorder(Node node){ //returns a string containing the nodes in the proper order according to postorder.
        if (node != null){
            return postorder(node.leftChild) + postorder(node.rightChild) + node.element + " ";
        }
        return "";
    }

}
