package code.practice.dsa.tree;

public class TreeExecutionClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node bst = new Node(10);
		bst.insert(5);
		bst.insert(8);
		bst.insert(15);
		bst.insert(11);
		bst.printInOrder();
		System.out.println();
		System.out.println(bst.contains(8));
		System.out.println(bst.contains(9));
		bst.printPreOrder();
		System.out.println();
		bst.printPostOrder();
	}

}
