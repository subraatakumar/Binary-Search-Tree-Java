# Binary-Search-Tree-Java
Different binary search tree operations are tried to explain in this repository

## Traversal : visiting each element of a tree.

Four types of traversal are :
- Preorder Traversal : process root node, then its left/right subtrees
- Inorder Traversal : process left subtree, then root node, then right
- Postorder Traversal : process left/right subtrees, then root node
- Level Order Traversal : Process level wise

## Preorder Traversal Method
~~~java
  public void preorder(Node node) {
    if(node == null) {
      return;
    }
    
    System.out.print(node.data + " ");
    preorder(node.left);
    preorder(node.right);
  }
~~~

## Inorder Traversal Method
~~~java
  public void inorder(Node node) {
    if(node == null) {
      return;
    }
    
    inorder(node.left);
    System.out.print(node.data + " ");
    inorder(node.right);
  }
~~~

## Postorder Traversal Method
~~~java
  public void postorder(Node node) {
    if(node == null) {
      return;
    }
    
    postorder(node.left);
    postorder(node.right);
    System.out.print(node.data+ " ");
  }
~~~  

## Level Order Traversal Method
~~~java
public static void levelOrder(Node root) {
       if(root == null) {
           return;
       }
       Queue<Node> q = new LinkedList<>();
       q.add(root);
       q.add(null);
       while(!q.isEmpty()) {
           Node curr = q.remove();
           if(curr == null) {
               System.out.println();
               //queue empty
               if(q.isEmpty()) {
                   break;
               } else {
                   q.add(null);
               }
           } else {
               System.out.print(curr.data+" ");
               if(curr.left != null) {
                   q.add(curr.left);
               }
               if(curr.right != null) {
                   q.add(curr.right);
               }
           }
       }
   }
~~~

## Delete a Node Method

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

## Check if a value exists in Binary Search Tree
~~~java
  public boolean ifNodePresent(Node node, int val) {
    if(node == null) {
      return false;
    }
    
    boolean isPresent = false;
    
    while(node != null) {
      if(val < node.data) {
        node = node.left;
      } else if(val > node.data) {
        node = node.right;
      } else {
        isPresent = true;
        break;
      }
    }
    
    return isPresent;
  }
~~~

## Get parent node of a given value in Binary Search Tree
~~~java
  public Node getParentNode(Node node, int val) {
    if(node == null) {
      return null;
    }
    
    Node getParent = null;
    
    while(node != null) {
      if(val < node.data) {
        getParent = node;
        node = node.left;
      } else if (val > node.data) {
        getParent = node;
        node = node.right;
      } else {
        break;
      }
    }

    return getParent;
  }
~~~

## Get Sibling Node of given value in Binary Search Tree
~~~java
  public Node getSiblingNode(Node node, int val) {
    if(node == null || node.data == val) {
      return null;
    }
    
    Node parentNode = null;
    
    while(node != null) {
      if(val < node.data) {
        parentNode = node;
        node = node.left;
      } else if(val > node.data) {
        parentNode = node;
        node = node.right;
      } else {
        break;
      }
    }
    
    if(parentNode.left != null && val == parentNode.left.data) {
      return parentNode.right;
    }
    
    if(parentNode.right != null && val == parentNode.right.data) {
      return parentNode.left;
    }
    
    return null;
  }
~~~

## Get Inorder Parent for a given value in Binary Search Tree

value of parent should be greater then the child
~~~java
  public Node getInorderParent(Node node, int val) {
    if(node == null) {
      return null;
    }
    
    Node inorderParent = null;
    
    while(node != null) {
      if(val < node.data) {
        inorderParent = node;
        node = node.left;
      } else if (val > node.data) {
        node = node.right;
      } else {
        break;
      }
    }
    
    return node != null ? inorderParent : null;
  }
~~~

## Get Inorder Successor of a given value in Binary Search Tree

Find bigger number of the given node
~~~java
  public Node getInorderSuccessor(Node node, int val) {
    if(node == null) {
      return null;
    }
    
    Node inorderSuccessor = null;
    
    while(node != null) {
      if(val < node.data) {
        inorderSuccessor = node;
        node = node.left;
      } else if (val > node.data) {
        node = node.right;
      } else {
        if(node.right != null) {
          inorderSuccessor = getSuccessor(node);
        }
        break;
      }
    }
    return node != null ? inorderSuccessor : null;
  }
~~~

## Get Difference of Even & Odd level values

Find sum of values at Even level then find sum of values in odd level and then find their difference
~~~java
  public int getDifferenceEvenOddLevel(Node node) {
    if(node == null) {
      return 0;
    }
    
    return node.data - getDifferenceEvenOddLevel(node.left) - getDifferenceEvenOddLevel(node.right);
  }
~~~

## Get Max value element in Binary Search Tree

Find the rightmost element. Because rightmost element of a Binary search tree is the Max.
~~~java
  public int getMax(Node node) {
    if(node == null) {
      System.out.println("Tree is EMpty");
      return -1;
    }
    
    while(node.right != null) {
      node = node.right;
    }
    
    return node.data;
  }
~~~

## Get Min value element in Binary Search Tree

Find the leftmost element. Because the leftmost element of a binary search tree is the minimum.
~~~java
  public int getMin(Node node) {
    if(node == null) {
      System.out.println("Tree is EMpty");
      return -1;
    }
    
    while(node.left != null) {
      node = node.left;
    }
    
    return node.data;
  }
~~~


