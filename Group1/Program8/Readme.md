##Assignment 

This assignment creates a GUI calculator. This is an exercise using the Stack data structure

For Program 8 you will create a simple calculator application that works similarly to the calculators that Hewlett- Packard produced in the 1970's. These calculators were unusual in that the user entered the numbers and operators in what is known as Reverse Polish or Postorder. In order to do a computation you first entered the numbers and then the operator you want to apply to them. For instance, to calculate 2 + 3, you enter the following:

2 <Enter> 3 <Enter> <+>

and the calculator would display 5. This system is easy to implement using a stack. Every time the user clicks <Enter>, the number currently in the display is pushed onto the stack. When a user clicks one of the operators (<+>, < ->, <*>, </>) the calculator pops the top 2 values off the stack, applies the chosen operator and pushes the result on to the stack. This procedure for entering operators and operands has the advantage of never needing parentheses.

Suggested classes: Calculator