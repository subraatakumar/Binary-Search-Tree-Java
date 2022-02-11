package bst;
import java.util.*;

public class BinarySearchTreeLab
{
   private Node root;
   
   //constructor
   public BinarySearchTreeLab() {
	   root = null;
   }
   
   public void delete(int val) {
	   if(root == null) {
		   System.out.println("Empty Tree");
	   }
	   
	   root = delete(root, val);
   }
   // Count Nodes
   public int countOfNodes() {
       if(root == null) {
           return 0;
       }
       
       return countOfNodes(root);
   }
   private int countOfNodes(Node root) {
       if(root == null) {
           return 0;
       }
 
       int leftNodes = countOfNodes(root.left);
       int rightNodes = countOfNodes(root.right);
       return leftNodes + rightNodes + 1;
   }   
   // Count Leaves
   public int countLeaves() {
       if(root == null) {
           return 0;
       }
       
       return countLeaves(root);
   }
   private int countLeaves(Node root) {
       if(root == null) {
           return 0;
       }
       if(root.left == null && root.right == null)
    	   return 1;
       
       int leftNodes = countLeaves(root.left);
       int rightNodes = countLeaves(root.right);
       return leftNodes + rightNodes;
   }    
   // remove node
   private Node delete(Node node, int val) {
	    if(node == null) {
	      return node;
	    }
	    
	    if(val < (int)node.data) {
	      node.left = delete(node.left, val);
	    } else if(val > (int)node.data) {
	      node.right = delete(node.right, val);
	    } else {
	      if(node.left == null || node.right == null) {
	        Node temp = node.left != null ? node.left : node.right;

	        if(temp == null) {
	          return null;
	        } else {
	          return temp;
	        }
	      } else {
	        Node successor = getSuccessor(node);
	        node.data = successor.data;
	        
	        node.right = delete(node.right, (int)successor.data);
	        return node;
	      }
	    }
	    
	    return node;
   }   
   
   public Node getSuccessor(Node node) {
	    if(node == null) {
	      return null;
	    }
	    
	    Node temp = node.right;
	    
	    while(temp.left != null) {
	      temp = temp.left;
	    }
	    
	    return temp;
	}   
   //add method
   public void add(int value) {
	   root = add( root, value);
   }
   private Node add( Node n, int value) {
	   if ( n == null) {
		   n = new Node(value, null, null);
	   } else if ( n.data.compareTo(value)>0) {
		   n.left = add( n.left, value);
	   } else if ( n.data.compareTo(value)<0) {
		   n.right = add( n.right, value);
	   }
	   return n;
   }
   
   public void inOrder() {
	   if(root == null) {
		   System.out.println("Empty Tree");
	   }
	   
	   inOrder(root);
   }
   
   private void inOrder( Node n )
   {
	   if( n != null )
	   {
		   inOrder( n.left );
		   System.out.println( n.data );
		   inOrder( n.right );
	   }
   }   
   public void preOrder() {
	   if(root == null) {
		   System.out.println("Empty Tree");
	   }
	   
	   preOrder(root);
   }
   
   private void preOrder( Node n )
   {
	   if( n != null )
	   {
		   System.out.println( n.data );
		   preOrder( n.left );
		   preOrder( n.right );
	   }
   } 
   /*
	    70   -  add + traversals – inOrder, preorder, postOrder, revOrder
	    
        80   -  70  + remove, smallest, largest, find
        
        90   -  80  + sumNodes, countLeaves, levelOrder traversal [ use a Q ], and isBST [ is the tree a binary search tree ]
        
        100  -  90  + getHeight, getWidth, isFull, and isComplete
        
        110  -  100 + mirror [ return a new tree ] + 
                    printem tree where it lookem like tree 
                    
    */

}
