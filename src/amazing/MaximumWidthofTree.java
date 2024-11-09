package amazing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Tree{
	int data;
	Tree left, right;
	Tree(int newdata){
		data = newdata;
		left = right = null;
	}
}



public class MaximumWidthofTree {
	Tree root;
	Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
	public void getWidth(){
		myMap.put(0, 0);
		letsee(root, 0);
	}

	public void letsee(Tree newroot, int currentlevel){
		int value = 0;
		if(newroot.left!=null)
			value++;
		if(newroot.right!=null)
			value++;
		if(myMap.get(currentlevel+1)!=null){
			int test = myMap.get(currentlevel+1);
			myMap.put(currentlevel+1, test+value);
		}
		else
			myMap.put(currentlevel+1, value);
		
		if(newroot.left!=null)
			letsee(newroot.left,currentlevel+1);
		if(newroot.right!=null)
			letsee(newroot.right,currentlevel+1);
		
	}
	
	public static void main(String[] args) {
		MaximumWidthofTree tree = new MaximumWidthofTree();
		tree.root = new Tree(1);
		  tree.root.left = new Tree(2);
		    tree.root.right = new Tree(3);
		    tree.root.left.left = new Tree(4);
		    tree.root.left.right = new Tree(5);
		    tree.root.right.right = new Tree(8);
		    tree.root.right.right.left = new Tree(6);
		    tree.root.right.right.right = new Tree(7);
		    
		   
		    
		tree.getWidth();
		tree.displayMap();
	}

	private void displayMap() {
		for (Entry<Integer, Integer> itr : myMap.entrySet()) {
			System.out.println(itr.getKey()+" "+itr.getValue());
		}
	}
}
