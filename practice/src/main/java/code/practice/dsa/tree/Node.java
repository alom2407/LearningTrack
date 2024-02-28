package code.practice.dsa.tree;

public class Node {
	Node left,right;
	int data;
	
	public Node(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}
	
	public void insert(int value) {
		if(value <= data) {
			if(left == null) {
				left = new Node(value);
			}
			else {
				left.insert(value);
			}
		}
		else {
			if(right == null) {
				right = new Node(value);
			}
			else {
				right.insert(value);
			}
		}
	}
	
	public boolean contains(int value) {
		if(data==value)
			return true;
		if(value<=data) {
			if(left == null)
				return false;
			else
				return left.contains(value);
		}
		else {
			if(right == null)
				return false;
			else
				return right.contains(value);
		}
	}
	
	public void printInOrder() {
		if(left != null) {
			left.printInOrder();
		}
		System.out.print(data);
		if(right != null) {
			right.printInOrder();
		}
	}
	
	public void printPreOrder() {
		System.out.print(data);
		if(left!=null) {
			left.printPreOrder();
		}
		if(right!=null) {
			right.printPreOrder();
		}
	}
	
	public void printPostOrder() {
		
		if(left!=null) {
			left.printPreOrder();
		}
		if(right!=null) {
			right.printPreOrder();
		}
		System.out.print(data);
	}
}
