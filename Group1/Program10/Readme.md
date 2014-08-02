##Assignment

The purpose of Prog10 is to create a converter that will read in an infix expression and create a binary tree that represents this expression. The program will then optimize the expression by manipulating the binary tree and then write it out in several different forms.

To evaluate a complex infix expression, a compiler would first convert the expression to a binary tree and then generate code for the expression in postfix form. Each of these algorithms requires only a single left-to-right pass of the expression. Each algorithm uses a stack in support of its operation, but each uses the stack for a different reason.

In this program you will write an infix-to-binarytree conversion algorithm that converts an ordinary infix arithmetic expression (assume a valid expression is entered) with integers and operators separated by blanks:

( 16 + 2 ) * 5 - 28 / 4

Suggested Classes: InFixToBinaryTreeConverter, Node