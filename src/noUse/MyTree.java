package noUse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;



public class MyTree {
	
	class Tree{
		int key;
		Tree left;
		Tree right;
		Tree(int data){
			key = data;
			left = right = null;
		}
	}
	
	Tree root = null;
	
	public void insert(int data){
		root = insertNode(root, data);
	}
	
	public Tree insertNode(Tree newRoot,int data){
		if(newRoot==null){
			newRoot = new Tree(data);
			return newRoot;
		}else{
			if(data<newRoot.key){
				newRoot.left = insertNode(newRoot.left, data);
			}else{
				newRoot.right =insertNode(newRoot.right, data);
			}
		}
		return newRoot;	
	}
	
	List<Tree> obj = new ArrayList<Tree>();
	public void bfs1(){
		obj.add(root);
		bfs(root);
		for (Tree oo : obj) {
			System.out.println(oo.key+"->");
		}
	}
	public void bfs(Tree myroot){
		if(myroot==null)
			return;
		else{
			if(myroot.left!=null)
			obj.add(myroot.left);
			if(myroot.right!=null)
			obj.add(myroot.right);
			bfs(myroot.left);
			bfs(myroot.right);
		}
	}
	
	Stack<Tree> stackTree = new Stack<>();
	public void dfs1(){
		dfs(root);
		while (!stackTree.isEmpty()) {
			System.out.println(stackTree.pop().key);
		}
	}
	public void dfs(Tree myRoot){
		if(myRoot==null)
			return;
		else{
			stackTree.add(myRoot);
			dfs(myRoot.left);
			dfs(myRoot.right);
		}
	}
	
	public void print(){
		printInorder(root);
	}
	public void printInorder(Tree root){
		if(root==null){
			return;
		}else{
			printInorder(root.left);
			System.out.println(root.key+"==>");
			printInorder(root.right);
		}
	}
	public void findHeight(){}
	
	public static void main(String[] args) {
		MyTree obj = new MyTree();
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(5);
		obj.print();
		obj.bfs1();
		obj.dfs1();
	}
}
