package bst;

public class Node
{
	Comparable data;
	Node left;
	Node right;
	
	public Node( Comparable v, Node l, Node r){
		data = v;
		left = l;
		right = r;
	}

	public String toString(){
		return "" + data + " " + left + " " + right;
	}
}
