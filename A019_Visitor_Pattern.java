import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int total = 0;

    public int getResult() { return total; }

    public void visitNode(TreeNode node) { }

    public void visitLeaf(TreeLeaf leaf) { total += leaf.getValue(); }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private int total = 1;
    private final int M = 1000000007;

    public int getResult() { return (int) total; }

    public void visitNode(TreeNode node) {
      	if (node.getColor().equals(Color.RED)) total = (total * node.getValue()) % M;
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.RED)) total = (total * leaf.getValue()) % M;
    }
}

class FancyVisitor extends TreeVis {
    private int firstSum = 0;
    private int secondSum = 0;

    public int getResult() {
        return Math.abs(firstSum - secondSum);
    }

    public void visitNode(TreeNode node) {
    	if (node.getDepth() % 2 == 0) firstSum += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if (leaf.getColor().equals(Color.GREEN)) secondSum += leaf.getValue();
    }
}

public class A019_Visitor_Pattern {
  
    private static HashMap<Integer, HashSet<Integer>> map;
    static List<Integer> values = new ArrayList<>();
    static List<Color> colors = new ArrayList<>();

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner scan = new Scanner(System.in);
        
        int cant_nodes = scan.nextInt();                                            // Get nodes
        for (int i=0;i<cant_nodes;i++) values.add(scan.nextInt());                  // Get values
        for (int i=0;i<cant_nodes;i++) colors.add(Color.values()[scan.nextInt()]);  // Get colors

        map = new HashMap(cant_nodes);

        /* Save edges */
        for (int i = 0; i < cant_nodes - 1; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            
            /* Edges are undirected: Add 1st direction */
            HashSet<Integer> uNeighbors = map.get(u);
            if (uNeighbors == null) {                
                uNeighbors = new HashSet();
                map.put(u, uNeighbors);
            }
            uNeighbors.add(v);
            
            /* Edges are undirected: Add 2nd direction */
            HashSet<Integer> vNeighbors = map.get(v);
            if (vNeighbors == null) {
                vNeighbors = new HashSet();
                map.put(v, vNeighbors);
            }
            vNeighbors.add(u);
        }
        scan.close();
        
        /* Handle 1-node tree */
        if (cant_nodes == 1) {
            return new TreeLeaf(values.get(0), colors.get(0), 0);
        }

        /* Create Tree */
        TreeNode root = new TreeNode(values.get(0), colors.get(0), 0);
        addChildren(root, 1);
        return root;
    }

    /* Recursively adds children of a TreeNode */
    private static void addChildren(TreeNode parent, Integer parentNum) {
        /* Get HashSet of children and loop through them */
        for (Integer treeNum : map.get(parentNum)) {
            map.get(treeNum).remove(parentNum); // removes the opposite arrow direction
            
            /* Add child */
            HashSet<Integer> grandChildren = map.get(treeNum);
            boolean childHasChild = (grandChildren != null && !grandChildren.isEmpty());
            Tree tree;
            if (childHasChild) {
                tree = new TreeNode(values.get(treeNum-1), colors.get(treeNum-1), parent.getDepth() + 1);
            } else {
                tree = new TreeLeaf(values.get(treeNum-1), colors.get(treeNum-1), parent.getDepth() + 1);
            }
            parent.addChild(tree);

            /* Recurse if necessary */
            if (tree instanceof TreeNode) {
                addChildren((TreeNode) tree, treeNum);
            }
        }
    }

 
    


    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}