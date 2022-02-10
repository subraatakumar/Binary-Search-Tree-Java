# Binary-Search-Tree-Java
Different binary search tree operations are tried to explain in this repository

## Traversal : visiting each element of a tree.

Four types of traversal are :
- Preorder Traversal : process root node, then its left/right subtrees
- Inorder Traversal : process left subtree, then root node, then right
- Postorder Traversal : process left/right subtrees, then root node
- Level Order Traversal : Process level wise

~~~java
  public Node delete(Node node, int val) {
    if(node == null) {
      return node;
    }
    
    if(val < node.data) {
      node.left = delete(node.left, val);
    } else if(val > node.data) {
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
        
        node.right = delete(node.right, successor.data);
        return node;
      }
    }
    
    return node;
  }
~~~
