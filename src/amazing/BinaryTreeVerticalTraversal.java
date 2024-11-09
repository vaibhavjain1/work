package amazing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Node{
	int data;
	Node left,right;
	public Node(int mydata){
		data = mydata;
		left = right = null;
	}
}

public class BinaryTreeVerticalTraversal {

	Node root;
	
	Map<Integer, Integer> mymap = new HashMap<>();
	public void letsee(){
		mymap.put(root.data, 0);
		traverse(root,0);
	}
	
	public void traverse(Node newroot, int currValue){
		if(newroot.left!=null)
			mymap.put(newroot.left.data, currValue+1);
		if(newroot.right!=null)
			mymap.put(newroot.right.data, currValue-1);
		if(newroot.left!=null)
			traverse(newroot.left, currValue+1);
		if(newroot.right!=null)
			traverse(newroot.right, currValue-1);
		
	}
	
	public void printHashMap(){
		for (Entry itr : mymap.entrySet()) {
			System.out.println(itr.getKey()+" "+itr.getValue());
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeVerticalTraversal tree = new BinaryTreeVerticalTraversal();
		tree.root = new Node(1);
	    tree.root.left = new Node(2);
	    tree.root.right = new Node(3);
	    tree.root.left.left = new Node(4);
	    tree.root.left.right = new Node(5);
	    tree.root.right.left = new Node(6);
	    tree.root.right.right = new Node(7);
	    tree.root.right.left.right = new Node(8);
	    tree.root.right.right.right = new Node(9);
	    tree.letsee();
	    tree.printHashMap();
	}
	
	
}
