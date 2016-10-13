import java.util.*;

class CS6085ASurati {
	
	static Lab5BTMethods one = new Lab5BTMethods();
	static int elements[] ;
	static int temp = 0;
    static int count=0;
	
	public static void main(String[] args) {

		System.out.println("Name: Vinitkumar Surati");
	    System.out.println("Course No.: CS608");	  
	    Date date = new Date();
	    System.out.println(date.toString()+"\n");
	    System.out.println("PROGRAM TO DEMONSTRATE BINARY TREES");
		
		one.createBinaryTree();
		elements = new int[numberOfNodes(one.root)];
		System.out.println();
		System.out.println("Binary Tree Pre-order Traversal Output: ");
		one.preOrder(one.root);
		System.out.println();
		System.out.println("\nHeight of the binary tree is "+one.height(one.root));
		System.out.print("\nLevel order of the binary tree: ");
		one.displayTree(one.root);
		System.out.println("\n\nNumber of nodes in the binary tree are " + numberOfNodes(one.root));
		largest(one.root);
		System.out.print("\nLargest element in the binary tree is " + temp + "\n");

	}
	static int numberOfNodes(Lab5BTNode root){
		if(root == null)
			return 0;
		else 
			return(numberOfNodes(root.right) + numberOfNodes(root.left) + 1);
	}
	
	static void largest(Lab5BTNode root){
		
		if(root!=null)
		{
			elements[count++] = root.element;
			largest(root.left);
			largest(root.right);
		}
		for (int i =0; i<elements.length; i++) {
			if(elements[i]>temp){
				temp = elements[i];
			}
		}

	}
}