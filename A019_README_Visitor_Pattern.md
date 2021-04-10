# Visitor Pattern Challenge

## Note: In this problem you must NOT generate any output on your own.

Open/closed principle. In other words, new functionality should be added by writing an extension for the existing code rather than modifying it and potentially breaking other code that uses it.

A Tree class implementing a rooted tree is provided. It has the following publicly available methods:

* getValue(): Returns the value stored in the node.
* getColor(): Returns the color of the node.
* getDepth(): Returns the depth of the node. Recall that the depth of a node is the number of edges between the node and the tree's root, so the tree's root has depth "0" and each descendant node's depth is equal to the depth of its parent node "+1".

We treat the internal implementation of the tree as being closed to modification, so we cannot directly modify it; The implementation is written in such a way that it allows external classes to extend and build upon its functionality. More specifically, it allows objects of the TreeVis class
(a Visitor Design Pattern) to visit the tree and traverse the tree structure via the accept method.

--------------

## Part I: Implement Three Different Visitors

1) getResult(): Return an integer denoting the "result", which is different for each class:

* The SumInLeavesVisitor implementation must return the sum of the values in the tree's leaves only.
* The ProductRedNodesVisitor implementation must return the product of values stored in all red nodes, including leaves, computed modulo 10^9 + 7.    Note that the product of zero values is equal to 1.
* The FancyVisitor implementation must return the absolute difference between the sum of values stored in the tree's non-leaf nodes at even depth and
the sum of values stored in the tree's green leaf nodes. Recall that 0 is an even number.

2) visitNode(TreeNode node): Implement the logic responsible for visiting the tree's non-leaf nodes such that the getResult method returns the correct "result" for the implementing class' visitor.
3) visitLeaf(TreeLeaf leaf): Implement the logic responsible for visiting the tree's leaf nodes such that the getResult method returns the correct "result" for the implementing class' visitor.

--------------

## Part II: Read and Build the Tree

Read the "n-node" tree, where each node is numbered from 1 to "n". The tree is given as a list of node values (x1,x2,....xn), a list of node colors (c1,c2,....,cn), and a list of edges. Construct this tree as an instance of the Tree class. The tree is always rooted at node number 1.

Your implementations of the three visitor classes will be tested on the tree you built from the given input.

--------------

## Constraints

2 <= n <= 10^5
1 <= xi <= 10^3
ci = 0 || ci = 1
1 <= vi,ui <= n
It is guaranteed that the tree is rooted at node 1.

--------------

## Sample Input

5                   # Number of nodes in the tree

4 7 2 5 12          # x1,x2,....,xn

0 1 0 0 1           # c1,c2,....,cn : colors (0:red, 1:green)

1 2                 # from this line: ui and vi (edge between nodes)

1 3

3 4

3 5

## Sample Output

Do not print anything to stdout. The three getResult() methods provided for you must return an integer denoting the "result" for that class' visitor (defined above). Note that the value returned by ProductRedNodesVisitor's getResult method must be computed modulo 10^9 + 7.

24

40

15

## Explanation

Creates a SumInLeavesVisitor object whose getResult method returns the sum of the leaves in the tree, which is 7+5+12=24. The locked stub code prints the returned value on a new line.

Creates a ProductOfRedNodesVisitor object whose getResult method returns the product of the red nodes, which is 4\*2\*5=40. The locked stub code prints the returned value on a new line.

Creates a FancyVisitor object whose getResult method returns the absolute difference between the sum of the values of non-leaf nodes at even depth and the sum of the values of green leaf nodes, which is |4-(7+12)|. The locked stub code prints the returned value on a new line.