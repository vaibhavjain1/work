package phase4.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {

	int val;
	Node left;
	Node right;
	
	Node(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
public class Tree {

	Node root;
	
	Tree(int val){
		this.root = new Node(val);
	}
	
	
	public static void bfs(Node root) {
		if(root==null)
			return;
		List<Node> myList = new ArrayList<>();
		myList.add(root);
		while(!myList.isEmpty()) {
			Node temp = myList.get(0);
			System.out.println(temp.val+" ");
			if(temp.left!=null)
				myList.add(temp.left);
			if(temp.right!=null)
				myList.add(temp.right);
			myList.remove(0);
		}
	}
	
	public static void dfs(Node root) {
		if(root == null)
			return;
		System.out.println(root.val+" ");
		dfs(root.left);
		dfs(root.right);
	}
	
	public static void printBoundaryTraversal(Node root) {
		if(root==null)
			return;
		Node temp = root;
		while(temp.left!=null) {
			System.out.println(temp.val);
			temp=temp.left;
		}
		
		temp = root;
		List<Node> myList = new ArrayList<>();
		myList.add(temp);
		while(!myList.isEmpty()) {
			Node temp1 = myList.get(0);
			if(temp1.left!=null)
				myList.add(temp1.left);
			if(temp1.right!=null)
				myList.add(temp1.right);
			if(temp1.left==null && temp1.right==null)
				System.out.println(temp1.val);
			myList.remove(0);
		}
		
	}
	
	public static void printzigzag(Node root) {
		if(root!=null) {
			Queue<Node> myList = new LinkedList<>();
			Queue<Node> myList1 = new LinkedList<>();
			myList.add(root);
			while (!(myList.isEmpty() && myList1.isEmpty())) {
				while(!myList.isEmpty()) {
					Node temp = myList.poll();
					System.out.println(temp.val);
					if(temp.left!=null)
						myList1.add(temp.left);
					if(temp.right!=null)
						myList1.add(temp.right);
				}
				java.util.Collections.reverse( (List<?>) myList1);
				while(!myList1.isEmpty()) {
					Node temp = myList1.poll();
					System.out.println(temp.val);
					if(temp.left!=null)
						myList.add(temp.left);
					if(temp.right!=null)
						myList.add(temp.right);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Tree obj= new Tree(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
		obj.root.left.left.left = new Node(8);
		obj.root.left.left.right = new Node(9);
		obj.root.left.right.left = new Node(10);
		obj.root.left.right.right = new Node(11);
		obj.root.right.left.left = new Node(12);
		obj.root.right.left.right = new Node(13);
		obj.root.right.right.left = new Node(14);
		obj.root.right.right.right = new Node(15);
		printzigzag(obj.root);
	}
}

