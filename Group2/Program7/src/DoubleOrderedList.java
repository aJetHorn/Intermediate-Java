
public class DoubleOrderedList {
	class Node {
	    String animal;
	    int amount;
	    Node nextAnimal;
	    Node nextAmount;
	    
	    public Node(String animal, int amount, Node nextAnimal, Node nextAmount) {
	      this.animal = animal;
	      this.amount = amount;
	      this.nextAnimal = nextAnimal;
	      this.nextAmount = nextAmount;
	    }
	    
	    public String toString() {
	      return animal + " " + amount;
	    }
	    
	  }
	  Node headAnimal;
	  Node headAmount;
	  
	  public DoubleOrderedList() {
	    headAnimal = null;
	    headAmount = null;
	  }
	  
	  public void add(String a,int n) {
	    if (headAnimal == null || headAnimal.animal.compareTo(a) > 0) {
	      headAnimal = new Node(a,n,headAnimal,null);
	    }
	    else {
	      Node temp = headAnimal;
	      while (temp.nextAnimal != null && temp.nextAnimal.animal.compareTo(a) < 0) {
	        temp = temp.nextAnimal;
	      }
	      temp.nextAnimal = new Node(a,n,temp.nextAnimal,null);
	    }
	    if (headAmount == null || headAmount.amount > n) {
	      headAmount = new Node(a,n,null,headAmount);
	    }
	    else {
	      Node temp = headAmount;
	      while (temp.nextAmount != null && temp.nextAmount.amount < n) {
	        temp = temp.nextAmount;
	      }
	      temp.nextAmount = new Node(a,n,null,temp.nextAmount);
	    }
	  }
	  
	  public void delete(String a) {
	    int flag = 1;
	    if(headAnimal == null || headAnimal.animal.compareTo(a) > 0) {
	      System.out.println(a + " is not in the list");
	    }
	    else if(headAnimal.animal.compareTo(a) == 0) {
	      headAnimal = headAnimal.nextAnimal;
	      flag = 0;
	      System.out.println(a + " was removed");
	    }
	    Node temp = headAnimal;
	    while (temp.nextAnimal != null && flag == 1) {
	      if (temp.nextAnimal.animal.compareTo(a) == 0) {
	        temp.nextAnimal = temp.nextAnimal.nextAnimal;
	        flag = 0;
	        System.out.println(a + " was removed");
	      }
	      else if (temp.nextAnimal != null) {
	        temp = temp.nextAnimal;
	      }
	    }
	    if (flag == 1) {
	      System.out.println(a + " is not in the list");
	    }
	    flag = 1;
	    if (headAmount.animal.compareTo(a) == 0) {
	      headAmount = headAmount.nextAmount;
	      flag = 0;
	    }
	    temp = headAmount;
	    while (temp.nextAmount != null && flag == 1) {
	      if (temp.nextAmount.animal.compareTo(a) == 0) {
	        temp.nextAmount = temp.nextAmount.nextAmount;
	        flag = 0;
	      }
	      else if (temp.nextAmount != null) {
	        temp = temp.nextAmount;
	      }
	    }
	  }
	  
	 public String toString(){
	    String tempString = "";
	    Node temp = headAnimal;
	    while (temp != null) {
	      tempString = tempString + temp + "-->";
	      temp = temp.nextAnimal;
	    }
	    return tempString + "null";
	  }
	  
	public String printAmount() {
	    String tempString = "";
	    Node temp = headAmount;
	    while (temp != null) {
	      tempString = tempString + temp + "-->";
	      temp = temp.nextAmount;
	    }
	    return tempString + "null";
	  } 
}
