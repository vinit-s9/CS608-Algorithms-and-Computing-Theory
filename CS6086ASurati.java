import java.io.*;
import java.util.*;
import java.text.*;
class BSTNode {

    BSTNode left;
    int element;
    BSTNode right;

    /* Constructor */
    public BSTNode() {}

    /* Constructor */
    public BSTNode(int n) {
        left = null;
        element = n;
        right = null;
    }
}

/* Creating a BST */
class BSTExample {
	
    static int[] input;
    static BSTNode root;
    BSTExample(String filename) throws Exception {
        File f1 = new File(filename);
        Scanner filereader = new Scanner(f1);
        ArrayList < Integer > al = new ArrayList < Integer > ();
        while (filereader.hasNextInt()) {
            al.add(filereader.nextInt());
        }
        input = new int[al.size()];
        for (int i = 0; i < input.length; i++) {
            input[i] = al.get(i);
        }

    }

    public void insertData(int element) {
        root = insert(root, element);     
    }

    static BSTNode insert(BSTNode node, int element) {
        if (node == null)
            node = new BSTNode(element);
        else {
            if (element <= node.element)
                node.left = insert(node.left, element);
            else
                node.right = insert(node.right, element);
        }
        return node;
    }

    static void inOrder(BSTNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.element + " ");
            inOrder(node.right);
        }
    }

    static boolean search(BSTNode node, int key) {
        if (node == null)
            return false;
        if (node.element == key)
            return true;
        else {
            if (key < node.element)
                return search(node.left, key);
            else
                return search(node.right, key);
        }
    }
    static int height(BSTNode node) {
        if (node == null) return -1;
        else {
            int tempLeft = height(node.left);
            int tempRight = height(node.right);
            if (tempLeft < tempRight) return tempRight + 1;
            else return tempLeft + 1;

        }
    }
    static int largest(BSTNode node) {
        if (node == null)
            return -1;
        while (node.right != null) {
            node = node.right;
        }
        return node.element;
    }
    static int numberOfNodes(BSTNode root) {
        if (root == null)
            return 0;
        else
            return (numberOfNodes(root.right) + numberOfNodes(root.left) + 1);
    }
    static int smallest(BSTNode node) {
        if (node == null) return -1;
        while (node.left != null) {
            node = node.left;
        }
        return node.element;

    }

    static void printElementsOnALevel(BSTNode node, int level){
        if (node == null)
            return;
        if (level == 0)
           System.out.print(node.element + " ");
        else if (level > 0) {
           printElementsOnALevel(node.left, level - 1);
           printElementsOnALevel(node.right, level - 1);
       }
    }
}

public class CS6086ASurati {
    public static void main(String[] args) throws Exception {
		System.out.println("Name: Vinitkumar Surati");
		System.out.println("Course No.: CS608");	  
		Date date = new Date();
		System.out.println(date.toString()+"\n");
		System.out.println("PROGRAM TO DEMONSTRATE BINARY SEARCH TREES");
	
        BSTExample one = new BSTExample("BSTData.txt");
		
		for (int i = 0; i < one.input.length; i++)
            one.insertData(one.input[i]);
		
		System.out.println("\nLevel order:");
        for (int i = 0; i <= one.height(one.root); i++) {
            System.out.println();
            one.printElementsOnALevel(one.root, i);
        }
		
        System.out.println("\n\nInorder traversal: ");  
        one.inOrder(one.root);
        
		System.out.print("\n\nHeight: " + one.height(one.root));
        
        System.out.println("\n\nNumber of nodes: " + one.numberOfNodes(one.root));
		
        System.out.println("\nLargest element: "+ one.largest(one.root));     
    
        Scanner s = new Scanner(System.in);
	int in=-1;
	System.out.print("\nSEARCH FOR AN ELEMENT");
	System.out.println("\n(YOU CAN ENTER 0 ANYTIME TO EXIT!)");
	while (in!=0) {
         System.out.print("\nEnter an element for a look-up: ");
         in = s.nextInt();
         if (in == 0) {
        	 System.out.println("\nEnd");   
        	 break;
         }

         System.out.println("Element found = " + one.search(one.root, in));

}
    }
}