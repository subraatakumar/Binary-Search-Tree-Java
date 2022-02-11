package bst;

import java.util.*;

public class BinarySearchTreeLab_Runner
{
   public static void main(String[] args)
   {
		int[] cases = { 90, 10, 87, 33, 24, 56, 22, 66, 221, 455, 11, -90, 3, 4, 5, 6, 7, -9, 100, 200, 300};
		
		BinarySearchTreeLab b = new BinarySearchTreeLab();
		b.add(90);
		b.add(10);
		b.add(87);
		b.add(33);
		b.add(24);
		b.add(56);
		System.out.println("Original Tree");
		b.preOrder();
//		b.delete(90);
//		System.out.println("Tree after Deletion");
//		b.preOrder();
//		System.out.println("Tree after Deletion");
//		b.inOrder();
		System.out.println("No of Nodes : "+b.countOfNodes());
		System.out.println("No of leaves : "+b.countLeaves());
		
		//for each loop through cases
			//add each value from case to the tree
			//print the tree after each add
			
		//print the tree after all adds
			//use in order
			//use pre order
			//use post order
			//use reverse order
		
		//for each loop through cases
			//delete each value from the tree
			//print the tree after each add				

   }
}
