
public class Node {
	String element;
    Node leftChild;
    Node rightChild;

    
    @Override
    public String toString(){ //overrides tostring
        return toString0(this);
    }
    public String toString0(Node node){ 
        if (node == null){
            return null;
        }
        else if (node.leftChild == null && node.rightChild == null){
            return node.element;
        }
        else {
            return (node.element + "(" + toString0(node.leftChild) + "," + toString0(node.rightChild) + ")");
            //return statement above recursively calls method to print parentheses and a comma, ends when base case is reached
        }
    }

    public Node(String s, Node left, Node right){ //basic constructor with parameters
        this.element = s;
        this.leftChild = left;
        this.rightChild = right;          
    }

}
