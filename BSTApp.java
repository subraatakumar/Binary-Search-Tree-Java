package bst;

class Node1 {
	  Node1 left;
	  Node1 right;
	  int data;
	}

class BST {
  public void inorder(Node1 Node1) {
	  // Print Root Node1 in middle
	    if(Node1 == null) {
	      return;
	    }
	    
	    inorder(Node1.left);
	    System.out.print(Node1.data + " ");
	    inorder(Node1.right);
	  }
	  
  public Node1 insert(Node1 Node1, int val) {
    if(Node1 == null) {
      return createNewNode1(val);
    }
    
    if(val < Node1.data) {
      Node1.left = insert(Node1.left, val);
    } else if((val > Node1.data)) {
      Node1.right = insert(Node1.right, val);
    }
    
    return Node1;
  }
  
  public Node1 createNewNode1(int k) {
    Node1 a = new Node1();
    a.data = k;
    a.left = null;
    a.right = null;
    return a;
  }
}
public class BSTApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    BST a = new BST();
	    Node1 root = null;
	    
	    root = a.insert(root, 8);
	    root = a.insert(root, 3);
	    root = a.insert(root, 6);
	    root = a.insert(root, 10);
	    root = a.insert(root, 4);
	    root = a.insert(root, 7);
	    root = a.insert(root, 1);
	    root = a.insert(root, 14);
	    root = a.insert(root, 13);
	    a.inorder(root);
	}
}
