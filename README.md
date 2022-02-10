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

## Height of tree
~~~java
public static int height(Node root) {
       if(root == null) {
           return 0;
       }
 
       int leftHeight = height(root.left);
       int rightHeight = height(root.right);
       return Math.max(leftHeight, rightHeight) + 1;
}
~~~

## Count of Nodes
~~~java
public static int countOfNodes(Node root) {
       if(root == null) {
           return 0;
       }
 
       int leftNodes = countOfNodes(root.left);
       int rightNodes = countOfNodes(root.right);
       return leftNodes + rightNodes + 1;
   }
~~~

## Sum of Nodes
~~~java
public static int sumOfNodes(Node root) {
       if(root == null) {
           return 0;
       }
 
       int leftSum = sumOfNodes(root.left);
       int rightSum = sumOfNodes(root.right);
       return leftSum + rightSum + root.data;
   }
~~~

## get Maximum Width
~~~java
    /* Function to get the maximum width of a binary tree*/
    int getMaxWidth(Node node)
    {
        int maxWidth = 0;
        int width;
        int h = height(node);
        int i;
 
        /* Get width of each level and compare
           the width with maximum width so far */
        for (i = 1; i <= h; i++) {
            width = getWidth(node, i);
            if (width > maxWidth)
                maxWidth = width;
        }
 
        return maxWidth;
    }
 
    /* Get width of a given level */
    int getWidth(Node node, int level)
    {
        if (node == null)
            return 0;
 
        if (level == 1)
            return 1;
        else if (level > 1)
            return getWidth(node.left, level - 1)
                + getWidth(node.right, level - 1);
        return 0;
    }
~~~

## Full Binary Tree

-If a binary tree node is NULL then it is a full binary tree.
-If a binary tree node does have empty left and right sub-trees, then it is a full binary tree by definition.

~~~java
    /* this function checks if a binary tree is full or not */
    boolean isFullTree(Node node)
    {
        // if empty tree
        if(node == null)
        return true;
          
        // if leaf node
        if(node.left == null && node.right == null )
            return true;
          
        // if both left and right subtrees are not null
        // the are full
        if((node.left!=null) && (node.right!=null))
            return (isFullTree(node.left) && isFullTree(node.right));
          
        // if none work
        return false;
    }
~~~

## Check isComplete

A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. 

Example:
~~~
                1
              /   \
             2     3
            / \     \
           4   5     6
~~~           
~~~java
 /* Given a binary tree, return true if the tree is complete
       else false */
    static boolean isCompleteBT(Node root)
    {
        // Base Case: An empty tree is complete Binary Tree
        if(root == null)
            return true;
         
        // Create an empty queue
        Queue<Node> queue =new LinkedList<>();
         
        // Create a flag variable which will be set true
        // when a non full node is seen
        boolean flag = false;
         
        // Do level order traversal using queue.
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node temp_node = queue.remove();
             
            /* Check if left child is present*/
            if(temp_node.left != null)
            {
                 // If we have seen a non full node, and we see a node
                 // with non-empty left child, then the given tree is not
                 // a complete Binary Tree
                if(flag == true)
                    return false;
                 
                 // Enqueue Left Child
                queue.add(temp_node.left);
            }
            // If this a non-full node, set the flag as true
            else
                flag = true;
             
            /* Check if right child is present*/
            if(temp_node.right != null)
            {
                // If we have seen a non full node, and we see a node
                // with non-empty right child, then the given tree is not
                // a complete Binary Tree
                if(flag == true)
                    return false;
                 
                // Enqueue Right Child
                queue.add(temp_node.right);
                 
            }
            // If this a non-full node, set the flag as true
            else
                flag = true;
        }
         // If we reach here, then the tree is complete Binary Tree
        return true;
    }
~~~
